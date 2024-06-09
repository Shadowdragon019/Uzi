

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

class UziDataTest {
	// null
	@Test fun null_() {
		assertFailsWith<NullPointerException> {
			UziData(null).write()
		}
	}
	
	// Boolean
	@Test fun writeTrue() {
		assertEquals( "true\n", UziData(true).write())
	}
	@Test fun writeFalse() {
		assertEquals("false\n", UziData(false).write())
	}
	@Test fun writeTrueComment() {
		assertEquals("# Imma comment!!!\ntrue\n", UziData("Imma comment!!!", true).write())
	}
	@Test fun writeFalseComment() {
		assertEquals("# Hehehe\nfalse\n", UziData("Hehehe", false).write())
	}
	
	// Int
	@Test fun write42() {
		assertEquals("42\n", UziData(42).write())
	}
	@Test fun write420Comment() {
		assertEquals(
			"# Wait, this is the drug number!!!! :(\n420\n",
			UziData("Wait, this is the drug number!!!! :(", 420).write()
		)
	}
	
	// Double
	@Test fun write1Point352() {
		assertEquals("1.352\n", UziData(1.352).write())
	}
	@Test fun write1Point352Comment() {
		assertEquals(
			"# CommentCommentComment\n1.352\n",
			UziData("CommentCommentComment", 1.352).write()
		)
	}
	
	// String
	@Test fun writeStringRawrUwU() {
		assertEquals("Rawr UwU\n", UziData("Rawr UwU").write())
	}
	@Test fun writeStringTrue() {
		assertEquals("\"true\"\n", UziData("true").write())
	}
	@Test fun writeStringFalse() {
		assertEquals("\"false\"\n", UziData("false").write())
	}
	@Test fun writeString433() {
		assertEquals("\"433\"\n", UziData("433").write())
	}
	@Test fun writeString4Point4983() {
		assertEquals("\"4.4983\"\n", UziData("4.4983").write())
	}
	@Test fun writeStringEmptyList() {
		assertEquals("\"emptyList\"\n", UziData("emptyList").write())
	}
	@Test fun writeStringEmptyMap() {
		assertEquals("\"emptyMap\"\n", UziData("emptyMap").write())
	}
	@Test fun writeStringWhitespaceBefore() {
		assertEquals("\"   Test   Dogs    Ha\"\n", UziData("   Test   Dogs    Ha").write())
	}
	@Test fun writeStringWhitespaceAfter() {
		assertEquals("\"Test   Dogs    Ha		 \"\n", UziData("Test   Dogs    Ha		 ").write())
	}
	@Test fun writeStringWhitespaceBeforeAndAfter() {
		assertEquals("\"   Test   Dogs    Ha     \"\n", UziData("   Test   Dogs    Ha     ").write())
	}
	@Test fun writeStringNewLine() {
		assertEquals("\"EEEE\nEEEE\"\n", UziData("EEEE\nEEEE").write())
	}
	@Test fun writeStringComment1() {
		assertEquals("\"#I not a comment!\"\n", UziData("#I not a comment!").write())
	}
	@Test fun writeStringComment2() {
		assertEquals("\"I not a comment either#!\"\n", UziData("I not a comment either#!").write())
	}

	// This one makes me happy
	@Test fun uziDataWriteStairs() {
		assertEquals("parent to block/block\n" +
				"display to\n" +
				"\tgui to\n" +
				"\t\trotation to\n" +
				"\t\t\t- 30\n" +
				"\t\t\t- 135\n" +
				"\t\t\t- 0\n" +
				"\t\ttranslation to\n" +
				"\t\t\t- 0\n" +
				"\t\t\t- 0\n" +
				"\t\t\t- 0\n" +
				"\t\tscale to\n" +
				"\t\t\t- 0.625\n" +
				"\t\t\t- 0.625\n" +
				"\t\t\t- 0.625\n" +
				"\thead to\n" +
				"\t\trotation to\n" +
				"\t\t\t- 0\n" +
				"\t\t\t- -90\n" +
				"\t\t\t- 0\n" +
				"\t\ttranslation to\n" +
				"\t\t\t- 0\n" +
				"\t\t\t- 0\n" +
				"\t\t\t- 0\n" +
				"\t\tscale to\n" +
				"\t\t\t- 1\n" +
				"\t\t\t- 1\n" +
				"\t\t\t- 1\n" +
				"\tthirdperson_lefthand to\n" +
				"\t\trotation to\n" +
				"\t\t\t- 75\n" +
				"\t\t\t- -135\n" +
				"\t\t\t- 0\n" +
				"\t\ttranslation to\n" +
				"\t\t\t- 0\n" +
				"\t\t\t- 2.5\n" +
				"\t\t\t- 0\n" +
				"\t\tscale to\n" +
				"\t\t\t- 0.375\n" +
				"\t\t\t- 0.375\n" +
				"\t\t\t- 0.375\n" +
				"textures to\n" +
				"\tparticle to \"#side\"\n" +
				"elements to\n" +
				"\t-\n" +
				"\t\tfrom to\n" +
				"\t\t\t- 0\n" +
				"\t\t\t- 0\n" +
				"\t\t\t- 0\n" +
				"\t\t\"to\" to\n" +
				"\t\t\t- 16\n" +
				"\t\t\t- 8\n" +
				"\t\t\t- 16\n" +
				"\t\tfaces to\n" +
				"\t\t\tdown to\n" +
				"\t\t\t\tuv to\n" +
				"\t\t\t\t\t- 0\n" +
				"\t\t\t\t\t- 0\n" +
				"\t\t\t\t\t- 16\n" +
				"\t\t\t\t\t- 16\n" +
				"\t\t\t\ttexture to \"#bottom\"\n" +
				"\t\t\t\tcullface to down\n" +
				"\t\t\tup to\n" +
				"\t\t\t\tuv to\n" +
				"\t\t\t\t\t- 0\n" +
				"\t\t\t\t\t- 0\n" +
				"\t\t\t\t\t- 16\n" +
				"\t\t\t\t\t- 16\n" +
				"\t\t\t\ttexture to \"#top\"\n" +
				"\t\t\tnorth to\n" +
				"\t\t\t\tuv to\n" +
				"\t\t\t\t\t- 0\n" +
				"\t\t\t\t\t- 8\n" +
				"\t\t\t\t\t- 16\n" +
				"\t\t\t\t\t- 16\n" +
				"\t\t\t\ttexture to \"#side\"\n" +
				"\t\t\t\tcullface to north\n" +
				"\t\t\tsouth to\n" +
				"\t\t\t\tuv to\n" +
				"\t\t\t\t\t- 0\n" +
				"\t\t\t\t\t- 8\n" +
				"\t\t\t\t\t- 16\n" +
				"\t\t\t\t\t- 16\n" +
				"\t\t\t\ttexture to \"#side\"\n" +
				"\t\t\t\tcullface to south\n" +
				"\t\t\twest to\n" +
				"\t\t\t\tuv to\n" +
				"\t\t\t\t\t- 0\n" +
				"\t\t\t\t\t- 8\n" +
				"\t\t\t\t\t- 16\n" +
				"\t\t\t\t\t- 16\n" +
				"\t\t\t\ttexture to \"#side\"\n" +
				"\t\t\t\tcullface to west\n" +
				"\t\t\teast to\n" +
				"\t\t\t\tuv to\n" +
				"\t\t\t\t\t- 0\n" +
				"\t\t\t\t\t- 8\n" +
				"\t\t\t\t\t- 16\n" +
				"\t\t\t\t\t- 16\n" +
				"\t\t\t\ttexture to \"#side\"\n" +
				"\t\t\t\tcullface to east\n" +
				"\t-\n" +
				"\t\tfrom to\n" +
				"\t\t\t- 8\n" +
				"\t\t\t- 8\n" +
				"\t\t\t- 0\n" +
				"\t\t\"to\" to\n" +
				"\t\t\t- 16\n" +
				"\t\t\t- 16\n" +
				"\t\t\t- 16\n" +
				"\t\tfaces to\n" +
				"\t\t\tup to\n" +
				"\t\t\t\tuv to\n" +
				"\t\t\t\t\t- 8\n" +
				"\t\t\t\t\t- 0\n" +
				"\t\t\t\t\t- 16\n" +
				"\t\t\t\t\t- 16\n" +
				"\t\t\t\ttexture to \"#top\"\n" +
				"\t\t\t\tcullface to up\n" +
				"\t\t\tnorth to\n" +
				"\t\t\t\tuv to\n" +
				"\t\t\t\t\t- 0\n" +
				"\t\t\t\t\t- 0\n" +
				"\t\t\t\t\t- 8\n" +
				"\t\t\t\t\t- 8\n" +
				"\t\t\t\ttexture to \"#side\"\n" +
				"\t\t\t\tcullface to north\n" +
				"\t\t\tsouth to\n" +
				"\t\t\t\tuv to\n" +
				"\t\t\t\t\t- 8\n" +
				"\t\t\t\t\t- 0\n" +
				"\t\t\t\t\t- 16\n" +
				"\t\t\t\t\t- 8\n" +
				"\t\t\t\ttexture to \"#side\"\n" +
				"\t\t\t\tcullface to south\n" +
				"\t\t\twest to\n" +
				"\t\t\t\tuv to\n" +
				"\t\t\t\t\t- 0\n" +
				"\t\t\t\t\t- 0\n" +
				"\t\t\t\t\t- 16\n" +
				"\t\t\t\t\t- 8\n" +
				"\t\t\t\ttexture to \"#side\"\n" +
				"\t\t\teast to\n" +
				"\t\t\t\tuv to\n" +
				"\t\t\t\t\t- 0\n" +
				"\t\t\t\t\t- 0\n" +
				"\t\t\t\t\t- 16\n" +
				"\t\t\t\t\t- 8\n" +
				"\t\t\t\ttexture to \"#side\"\n" +
				"\t\t\t\tcullface to east\n", UziData(mapOf(
			"parent" to UziData("block/block"),
			"display" to UziData(mapOf(
				"gui" to UziData(mapOf(
					"rotation" to UziData(listOf(
						UziData(30), UziData(135), UziData(0),
					)),
					"translation" to UziData(listOf(
						UziData(0), UziData(0), UziData(0),
					)),
					"scale" to UziData(listOf(
						UziData(0.625), UziData(0.625), UziData(0.625),
					)),
				)),
				"head" to UziData(mapOf(
					"rotation" to UziData(listOf(
						UziData(0), UziData(-90), UziData(0),
					)),
					"translation" to UziData(listOf(
						UziData(0), UziData(0), UziData(0),
					)),
					"scale" to UziData(listOf(
						UziData(1), UziData(1), UziData(1),
					)),
				)),
				"thirdperson_lefthand" to UziData(mapOf(
					"rotation" to UziData(listOf(
						UziData(75), UziData(-135), UziData(0),
					)),
					"translation" to UziData(listOf(
						UziData(0), UziData(2.5), UziData(0),
					)),
					"scale" to UziData(listOf(
						UziData(0.375), UziData(0.375), UziData(0.375),
					)),
				)),
			)),
			"textures" to UziData(mapOf(
				"particle" to UziData("#side")
			)),
			"elements" to UziData(listOf(
				UziData(mapOf(
					"from" to UziData(listOf(
						UziData(0), UziData(0), UziData(0)
					)),
					"to" to UziData(listOf(
						UziData(16), UziData(8), UziData(16)
					)),
					"faces" to UziData(mapOf(
						"down" to UziData(mapOf(
							"uv" to UziData(listOf(
								UziData(0), UziData(0), UziData(16), UziData(16)
							)),
							"texture" to UziData("#bottom"),
							"cullface" to UziData("down"),
						)),
						"up" to UziData(mapOf(
							"uv" to UziData(listOf(
								UziData(0), UziData(0), UziData(16), UziData(16)
							)),
							"texture" to UziData("#top"),
						)),
						"north" to UziData(mapOf(
							"uv" to UziData(listOf(
								UziData(0), UziData(8), UziData(16), UziData(16)
							)),
							"texture" to UziData("#side"),
							"cullface" to UziData("north"),
						)),
						"south" to UziData(mapOf(
							"uv" to UziData(listOf(
								UziData(0), UziData(8), UziData(16), UziData(16)
							)),
							"texture" to UziData("#side"),
							"cullface" to UziData("south"),
						)),
						"west" to UziData(mapOf(
							"uv" to UziData(listOf(
								UziData(0), UziData(8), UziData(16), UziData(16)
							)),
							"texture" to UziData("#side"),
							"cullface" to UziData("west"),
						)),
						"east" to UziData(mapOf(
							"uv" to UziData(listOf(
								UziData(0), UziData(8), UziData(16), UziData(16)
							)),
							"texture" to UziData("#side"),
							"cullface" to UziData("east"),
						)),
					)),
				)),
				UziData(mapOf(
					"from" to UziData(listOf(
						UziData(8), UziData(8), UziData(0)
					)),
					"to" to UziData(listOf(
						UziData(16), UziData(16), UziData(16)
					)),
					"faces" to UziData(mapOf(
						"up" to UziData(mapOf(
							"uv" to UziData(listOf(
								UziData(8),UziData(0),UziData(16),UziData(16),
							)),
							"texture" to UziData("#top"),
							"cullface" to UziData("up"),
						)),
						"north" to UziData(mapOf(
							"uv" to UziData(listOf(
								UziData(0),UziData(0),UziData(8),UziData(8),
							)),
							"texture" to UziData("#side"),
							"cullface" to UziData("north"),
						)),
						"south" to UziData(mapOf(
							"uv" to UziData(listOf(
								UziData(8),UziData(0),UziData(16),UziData(8),
							)),
							"texture" to UziData("#side"),
							"cullface" to UziData("south"),
						)),
						"west" to UziData(mapOf(
							"uv" to UziData(listOf(
								UziData(0),UziData(0),UziData(16),UziData(8),
							)),
							"texture" to UziData("#side"),
						)),
						"east" to UziData(mapOf(
							"uv" to UziData(listOf(
								UziData(0),UziData(0),UziData(16),UziData(8),
							)),
							"texture" to UziData("#side"),
							"cullface" to UziData("east"),
						)),
					)),
				)),
			)),
		)).write())
	}
}