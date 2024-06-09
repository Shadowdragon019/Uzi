@file:Suppress("unused")

import java.lang.System.Logger

val logger: Logger = System.getLogger("UziData")

fun Any?.println() = println(this)

fun Any?.print() = print(this)

fun makeTabs(tabCount: Int): String = "\t".repeat(tabCount)

class UziData<T>(var comment: String, val data: T) {
	constructor(data: T) : this("", data) // No comment

	override fun equals(other: Any?): Boolean =
		if (other is UziData<*>)
			data == other.data && comment == other.comment
		else
			false

	override fun hashCode(): Int {
		var result = data?.hashCode() ?: 0
		result = 31 * result + comment.hashCode()
		return result
	}

	private fun writeComment(tabCount: Int): String = if (comment.isNotEmpty()) "${makeTabs(tabCount)}# $comment\n" else ""

	private fun formatString(string: String): String = if (
		string.toBooleanStrictOrNull() != null || // "true"
		string.toIntOrNull() != null || // "1"
		string.toDoubleOrNull() != null || // "1.0"
		string in listOf("emptyList", "emptyMap", ' ') || // "emptyMap" or "emptyList" or " "
		string[0].isWhitespace() || // " eee"
		string[string.lastIndex].isWhitespace() || // "eee "
		'\n' in string || '#' in string // "\n" or "eeee#eee"
		)
		"\"$string\""
	else
		string
	// Include comment determine whether to include the comment for this piece of data.
	fun write(tabCount: Int = 0, includeComment: Boolean = true): String = // I'm thinking I should
		// include a "parentType" parameter to determine how to do stuff. It might be cleaner.
		// That'd be a whole rewrite so... later date.
		(if (comment.isNotEmpty() && includeComment) writeComment(tabCount) else "") + when (data) {
			is Boolean -> makeTabs(tabCount) + data.toString() + '\n'
			is Int -> makeTabs(tabCount) + data.toString() + '\n'
			is Double -> makeTabs(tabCount) + data.toString() + '\n'
			is String -> makeTabs(tabCount) + formatString(data as String) + '\n'

			is List<*> -> {
				val listData = data as List<*>
				var returnString = ""
				for (entry in listData) {
					returnString += if (entry !is UziData<*>)
						throw IllegalStateException("Entry of list was not type UziData. Was ${entry?.javaClass}")
					else
						entry.writeComment(tabCount) + makeTabs(tabCount)
					returnString += if (entry.data is List<*> || entry.data is Map<*, *>)
						// Format potentially empty list/map
						if (entry.data is List<*> && entry.data.isEmpty())
							"- emptyList\n"
						else if (entry.data is Map<*, *> && entry.data.isEmpty())
							"- emptyMap\n"
						else
							"-\n" + entry.write(tabCount + 1, false)
					else
						"- " + entry.write(0, false)
				}
				returnString
			}

			is Map<*, *> -> {
				val mapData = data as Map<*, *>
				var returnString = ""
				for (entry in mapData) {
					val key = if (entry.key is String) formatString(entry.key.toString()) else entry.key
					val value = entry.value
					returnString += if (value is UziData<*>)
						if (key is Int || key is Double || key is String)
							if (value.data is List<*> || value.data is Map<*, *>) {
								value.writeComment(tabCount) + makeTabs(tabCount) + key.toString() +
									// Format potentially empty list/map
									if (value.data is List<*> && value.data.isEmpty())
										" emptyList\n"
									else if (value.data is Map<*, *> && value.data.isEmpty())
										" emptyMap\n"
									else
										'\n' + value.write(tabCount + 1, false)
							} else
								value.writeComment(tabCount) + makeTabs(tabCount) + key.toString() + ' ' + value.write(0, false)
						else
							throw IllegalStateException("key is not int, double, or string. Was $key")
					else
						throw IllegalArgumentException("value is not UziData. Was $value")
				}
				returnString
			}

			null -> throw NullPointerException("data cannot be null")
			else -> throw IllegalArgumentException("${data!!::class} cannot be parsed. Data was $data")
		}
}

fun uziMap(comment: String = "", vararg pairs: Pair<*, UziData<*>>): UziData<Map<*, UziData<*>>> =
	UziData(comment, mapOf(*pairs))
fun uziMap(vararg pairs: Pair<*, UziData<*>>): UziData<Map<*, UziData<*>>> =
	UziData(mapOf(*pairs))

fun uziList(comment: String = "", vararg elements: UziData<*>): UziData<List<UziData<*>>> =
	UziData(comment, listOf(*elements))
fun uziList(vararg elements: UziData<*>): UziData<List<UziData<*>>> =
	UziData(listOf(*elements))

// These are fucking hell what the fuck
/*fun uziList(comment: String = "", vararg elements: Any): UziData<List<UziData<*>>> {
	return UziData(comment, elements.toList().map {
		if (it is UziData<*>) it else UziData(it)
	})
}
fun uziList(vararg elements: Any): UziData<List<UziData<*>>> =
	uziList("", elements)*/

fun uziData(comment: String = "", vararg elements: Any?): UziData<*> =
	if (elements.size > 1 || elements[0] is Pair<*, *>) {
		var isMap = true
		val map: MutableMap<Any?, Any?> = mutableMapOf()
		for (element in elements)
			if (element is Pair<*, *>)
				map[element.first] = if (element.second is UziData<*>) element.second else UziData(element.second)
			else {
				isMap = false
				break
			}
		if (isMap)
			UziData(comment, map)
		else
			UziData(elements.toList().map {
				if (it is UziData<*>) it else UziData(it)
			})
	} else
		UziData(comment, elements[0])

fun uziData(vararg elements: Any?): UziData<*> = uziData("", *elements)

infix fun Any.uziPair(value: Any): Pair<Any, UziData<*>> = if (value is UziData<*>)
	Pair(this, value)
else
	Pair(this, UziData("", value))
