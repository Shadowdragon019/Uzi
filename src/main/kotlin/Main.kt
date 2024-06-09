fun main() {
	/*
	UziData(mapOf(
		1 to UziData(1),
		"1" to UziData(1),
		"map" to UziData(mapOf(
			2 to UziData(2),
			"2" to UziData(2),
		))
	)).write().println()
	1: 1
	"1": 1
	map:
		2: 2
		"2": 2
	 */
	/*
	UziData(listOf(
		UziData(1),
		UziData(2),
		UziData(3),
		UziData(4),
		UziData(5),
		UziData(6),
		UziData(7),
		UziData(8),
		UziData(9),
		UziData(listOf(
			UziData(1),
			UziData(2),
			UziData(3),
		)),
		UziData(listOf(
			UziData(4),
			UziData(5),
			UziData(6),
		)),
		UziData(listOf(
			UziData(7),
			UziData(8),
			UziData(9),
		)),
	)).write().println()
	- 1
	- 2
	- 3
	- 4
	- 5
	- 6
	- 7
	- 8
	- 9
	-
		- 1
		- 2
		- 3
	-
		- 4
		- 5
		- 6
	-
		- 7
		- 8
		- 9
	 */

	/*
	UziData(listOf(
		UziData(1),
		UziData(2),
		UziData(3),
		UziData(listOf(
			UziData(1),
			UziData(2),
			UziData(3),
			UziData(listOf(
				UziData(1),
				UziData(2),
				UziData(3),
			)),
		)),
	)).write().println()

	listOf(
		1,2,3,
		listOf(
			1,2,3,
			listOf(
				1,2,3
			)
		)
	)
	*/

	/*
	UziData(listOf(
		UziData(listOf(
			UziData(listOf(
				UziData(1),
				UziData(2),
				UziData(3),
			)),
			UziData(1),
			UziData(2),
			UziData(3),
		)),
		UziData(1),
		UziData(2),
		UziData(3),
	)).write().println()
	listOf(
		listOf(
			listOf(
				1,2,3
			),
			1,2,3
		),
		1,2,3
	)*/

    /*UziData(mapOf(
        1 to UziData(1),
        "two" to UziData(2),
        "#leTREE" to UziData(3),
        "#:::four" to UziData("#:::four"),
        ":#::five" to UziData("#:::five"),
        "fuckingMap" to UziData(mapOf(
            1 to UziData(1),
            2 to UziData(2),
            3 to UziData(3),
            4 to UziData(4),
            "5" to UziData(5),
            "fuckingMap" to UziData(mapOf(
                1 to UziData(1),
                2 to UziData(2),
                3 to UziData(3),
                4 to UziData(4),
                5 to UziData(5),
            )),
        )),
    )).write().println()*/

    /*UziData(mapOf(
        "map" to UziData(mapOf(
            "map" to UziData(mapOf(
                "1" to UziData(1),
                "2" to UziData(2),
                "3" to UziData(3),
                "4" to UziData(4),
                "5" to UziData(5),
            )),
            "1" to UziData(1),
            "2" to UziData(2),
            "3" to UziData(3),
            "4" to UziData(4),
            "5" to UziData(5),
        )),
        "1" to UziData(1),
        "2" to UziData(2),
        "3" to UziData(3),
        "4" to UziData(4),
        "5" to UziData(5),
    )).write().println()*/

    /*UziData(mapOf(
        "1" to UziData(1),
        "2" to UziData(2),
        "3" to UziData(3),
        "4" to UziData(4),
        "5" to UziData(5),
        "map" to UziData(mapOf(
            "1" to UziData(1),
            "2" to UziData(2),
            "3" to UziData(3),
            "4" to UziData(4),
            "5" to UziData(5),
            "map" to UziData(mapOf(
                "1" to UziData(1),
                "2" to UziData(2),
                "3" to UziData(3),
                "4" to UziData(4),
                "5" to UziData(5),
            )),
        ))
    )).write().println()*/

    /*UziData(mapOf(
        "List!" to UziData(listOf(
            UziData(1),
            UziData(2),
            UziData(3),
        ))
    )).write().println()
    */

uziData(
    "anvil_cost" to 4,
    "description" to uziData(
        "translate" to "enchantment.minecraft.frost_walker"
    ),
    "effects" to uziData(
        "minecraft:damage_immunity" to uziList(
            uziData(
                "effect" to uziMap(),
                "requirements" to uziData(
                    "condition" to "minecraft:damage_source_properties",
                    "predicate" to uziData(
                        "tags" to uziData(
                            uziData(
                                "expected" to true,
                                "id" to "minecraft:burn_from_stepping"
                            ),
                            uziData(
                                "expected" to false,
                                "id" to "minecraft:bypasses_invulnerability"
                            )
                        )
                    )
                )
            )
        ),
        "minecraft:location_changed" to uziList(
            uziData(
                "effect" to uziData(
                    "type" to "minecraft:replace_disc",
                    "block_state" to uziData(
                        "type" to "minecraft:simple_state_provider",
                        "state" to uziData(
                            "Name" to "minecraft:frosted_ice",
                            "Properties" to uziData(
                                "age" to 0
                            )
                        )
                    ),
                    "height" to 1,
                    "offset" to uziData(0,-1,0),
                    "predicate" to uziData(
                        "type" to "minecraft:all_of",
                        "predicates" to uziData(
                            uziData(
                                "type" to "minecraft:matching_blocks",
                                "blocks" to "minecraft:air",
                                "offset" to uziData(0,1,0)
                            ),
                            uziData(
                                "type" to "minecraft:matching_fluid",
                                "fluids" to "minecraft:water"
                            ),
                            uziData(
                                "type" to "minecraft:unobstructed"
                            )
                        )
                    ),
                    "radius" to uziData(
                        "type" to "minecraft:clamped",
                        "max" to 16,
                        "min" to 0,
                        "value" to uziData(
                            "type" to "minecraft:linear",
                            "base" to 3,
                            "per_level_above_first" to 1
                        )
                    )
                ),
                "requirements" to uziData(
                    "condition" to "minecraft:entity_properties",
                    "entity" to "this",
                    "predicate" to uziData(
                        "flags" to uziData(
                            "is_on_ground" to true
                        )
                    )
                )
            )
        )
    ),
    "exclusive_set" to "#minecraft:exclusive_set/boots",
    "max_cost" to uziData(
        "base" to 25,
        "per_level_above_first" to 10,
    ),
    "max_level" to 2,
    "min_cost" to uziData(
        "base" to 10,
        "per_level_above_first" to 10
    ),
    "slots" to uziList(
        UziData("feet")
    ),
    "supported_items" to "#minecraft:enchantable/foot_armor",
    "weight" to 2
).write().println()
    /*
    anvil_cost: 4
    description:
        translate: enchantment.minecraft.frost_walker
    effects:
        "minecraft:damage_immunity":
            -
                effect: emptyMap
                requirements:
                    condition: "minecraft:damage_source_properties"
                    predicate:
                        tags:
                            -
                                expected: true
                                id: "minecraft:burn_from_stepping"
                            -
                                expected: false
                                id: "minecraft:bypasses_invulnerability"
        "minecraft:location_changed":
            -
                effect:
                    type: "minecraft:replace_disc"
                    block_state:
                        type: "minecraft:simple_state_provider"
                        state:
                            Name: "minecraft:frosted_ice"
                            Properties:
                                age: 0
                    height: 1
                    offset:
                        - 0
                        - -1
                        - 0
                    predicate:
                        type: "minecraft:all_of"
                        predicates:
                            -
                                type: "minecraft:matching_blocks"
                                blocks: "minecraft:air"
                                offset:
                                    - 0
                                    - 1
                                    - 0
                            -
                                type: "minecraft:matching_fluid"
                                fluids: "minecraft:water"
                            -
                                type: "minecraft:unobstructed"
                    radius:
                        type: "minecraft:clamped"
                        max: 16
                        min: 0
                        value:
                            type: "minecraft:linear"
                            base: 3
                            per_level_above_first: 1
                requirements:
                    condition: "minecraft:entity_properties"
                    entity: this
                    predicate:
                        flags:
                            is_on_ground: true
    exclusive_set: "#minecraft:exclusive_set/boots"
    max_cost:
        base: 25
        per_level_above_first: 10
    max_level: 2
    min_cost:
        base: 10
        per_level_above_first: 10
    slots:
        - feet
    supported_items: "#minecraft:enchantable/foot_armor"
    weight: 2
    */

    /*
    uziData(
        uziData(
            uziData(1,2,3),
            uziData(3,4,5),
            uziData(6,7,8)
        ),
        uziData(
            uziData(1,2,3),
            uziData(3,4,5),
            uziData(6,7,8)
        ),
        uziData(
            uziData(1,2,3),
            uziData(3,4,5),
            uziData(6,7,8)
        )
    ).parse().println()
    */

    /*
    uziData("a",
        1 to uziData("b",
            1 to uziData("c",
                1 to 1,
                2 to 2,
                3 to 3,
            ),
            2 to uziData("d",
                4 to 4,
                5 to 5,
                6 to 6,
            ),
            3 to uziData("e",
                7 to 7,
                8 to 8,
                9 to 9,
            ),
        ),
        2 to uziData("f",
            1 to uziData("g",
                1 to 1,
                2 to 2,
                3 to 3,
            ),
            2 to uziData("h",
                4 to 4,
                5 to 5,
                6 to 6,
            ),
            3 to uziData("i",
                7 to 7,
                8 to 8,
                9 to 9,
            ),
        ),
        3 to uziData("j",
            1 to uziData("k",
                1 to 1,
                2 to 2,
                3 to 3,
            ),
            2 to uziData("l",
                4 to 4,
                5 to 5,
                6 to 6,
            ),
            3 to uziData("m",
                7 to 7,
                8 to 8,
                9 to 9,
            ),
        ),
        "empty map" to uziMap("n"),
        "empty list" to uziList("o")
    ).parse().println()
    */
    uziList(
        uziList(
            uziList(
                uziData(0)
            )
        ),
        uziList(
            uziList(
                uziData(1)
            )
        ),
    ).write().println()
}
