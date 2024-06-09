@file:Suppress("unused")

import java.lang.System.Logger

val logger: Logger = System.getLogger("UziData")

fun <K, V, R> Map<K, V>.foldIndexed(initial: R, operation: (index: Int, accumulator: R, K, V) -> R): R {
	var index = 0
	var accumulator = initial
	for (entry in this) accumulator = operation(index++, accumulator, entry.key, entry.value)
	return accumulator
}

fun Any?.println() = println(this)

fun Any?.print() = print(this)

class UziData<T : Any>(var comment: String, val data: T) {
	constructor(data: T) : this("", data) // No comment

	override fun equals(other: Any?): Boolean =
		if (other is UziData<*>)
			data == other.data && comment == other.comment
		else
			false

	override fun hashCode(): Int {
		var result = data.hashCode()
		result = 31 * result + comment.hashCode()
		return result
	}

	override fun toString(): String = "UziData($data)"

	private fun makeTabs(tabCount: Int): String = "\t".repeat(tabCount)

	private fun isListOrMap(obj: Any?): Boolean =
		obj is List<*> && obj.isNotEmpty() ||
		obj is Map<*, *> && obj.isNotEmpty()

	private fun formatString(string: String, parentType: ParentType) = if
		(string.toBooleanStrictOrNull() != null ||
		string.toIntOrNull() != null ||
		string.toDoubleOrNull() != null ||
		string == "emptyList" ||
		string == "emptyMap" ||
		' ' in string ||
		'\n' in string ||
		'\t' in string ||
		parentType in listOf(ParentType.line, ParentType.key, ParentType.list) && string[0] == '#')
		"\"$string\""
	else
		string

	private fun requireUziData(obj: Any?) = when (obj) {
		is UziData<*> -> obj
		null -> throw Error("obj was null")
		else -> throw Error("obj is not UziData, was $obj")
	}

	private fun formatKey(key: Any?, parentType: ParentType): String =
		if (key is Boolean || key is Int || key is Double || key is String)
			if (key is String)
				formatString(key, parentType)
			else
				key.toString()
		else
			throw Error("key was not Boolean, Int, Double, or String. Was ${key!!::class}")

	private fun validValue(value: Any?): UziData<*> =
		if (value is UziData<*>)
			value
		else
			throw Error("value was not UziData. Was ${value!!::class}")

	private fun write(tabCount: Int, parentType: ParentType): String =
		(if (parentType == ParentType.line) makeTabs(tabCount) else "") +
		when (data) {
			is Boolean -> data
			is Int -> data
			is Double -> data
			is String -> formatString(data, parentType)
			is List<*> -> if (data.isEmpty()) "emptyArray" else
				data.foldIndexed("") { index, accumulator, element ->
					@Suppress("NAME_SHADOWING")
					val element = requireUziData(element)
					accumulator +
					makeTabs(tabCount) +
					'-' +
					(if (isListOrMap(element.data)) '\n' else ' ') +
					element.write(tabCount + 1, ParentType.list) +
					if (index == data.lastIndex) "" else '\n'
				}
			is Map<*, *> -> if (data.isEmpty()) "emptyMap" else
				data.foldIndexed("") { index: Int, accumulator: String, key: Any?, value: Any? ->
					@Suppress("NAME_SHADOWING")
					val key = formatKey(key, ParentType.key)
					@Suppress("NAME_SHADOWING")
					val value = validValue(value)
					accumulator +
					makeTabs(tabCount) +
					key +
					(if (isListOrMap(value.data)) '\n' else ' ') +
					value.write(tabCount + 1, ParentType.value) +
					if (index == data.size - 1) "" else '\n'
				}
				else -> throw Error("${data::class} with data $this cannot be written from")
	}

	fun write() = write(0, ParentType.line)
}

fun uziPair(pair: Pair<Any, Any>): Pair<Any, UziData<out Any>> =
	Pair(pair.first, if (pair.second is UziData<*>) pair.second as UziData<*> else UziData(pair.second))

fun uziMap(vararg pairs: Pair<Any, Any>): UziData<Map<Any, UziData<Any>>> {
	val map = mutableMapOf<Any, UziData<Any>>()
	for (pair in pairs) {
		@Suppress("NAME_SHADOWING")
		val pair = uziPair(pair)
		@Suppress("UNCHECKED_CAST")
		map[pair.first] = pair.second as UziData<Any>
	}
	return UziData(map)
}

fun uziList(vararg elements: Any): UziData<List<UziData<out Any>>> =
	UziData(elements.map {
		if (it is UziData<*>)
			it
		else
			UziData(it)
	})