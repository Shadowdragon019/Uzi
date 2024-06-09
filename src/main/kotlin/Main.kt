fun main() {
    println("START")
    /*UziData(listOf(
        // 0
        UziData(1),
        UziData(2),
        // 1
        UziData(listOf(
            UziData(1),
            UziData(2),
        )),
        UziData(listOf(
            UziData(1),
            UziData(2),
        )),
        // 2
        UziData(listOf(
            UziData(listOf(
                UziData(1),
                UziData(2),
            )),
            UziData(listOf(
                UziData(1),
                UziData(2),
            )),
        )),
        UziData(listOf(
            UziData(listOf(
                UziData(1),
                UziData(2),
            )),
            UziData(listOf(
                UziData(1),
                UziData(2),
            )),
        )),
        // 3
        UziData(listOf(
            UziData(listOf(
                UziData(listOf(
                    UziData(1),
                    UziData(2),
                )),
                UziData(listOf(
                    UziData(1),
                    UziData(2),
                )),
            )),
            UziData(listOf(
                UziData(listOf(
                    UziData(1),
                    UziData(2),
                )),
                UziData(listOf(
                    UziData(1),
                    UziData(2),
                )),
            )),
        )),
        UziData(listOf(
            UziData(listOf(
                UziData(listOf(
                    UziData(1),
                    UziData(2),
                )),
                UziData(listOf(
                    UziData(1),
                    UziData(2),
                )),
            )),
            UziData(listOf(
                UziData(listOf(
                    UziData(1),
                    UziData(2),
                )),
                UziData(listOf(
                    UziData(1),
                    UziData(2),
                )),
            )),
        )),
    )).write().println()*/
    /*UziData(mapOf(
        1 to UziData(2),
        3 to UziData(4),
        "map1" to UziData(mapOf(
            1 to UziData(2),
            3 to UziData(4),
        )),
        "map2" to UziData(mapOf(
            1 to UziData(2),
            3 to UziData(4),
        )),
        "map3" to UziData(mapOf(
            "map1" to UziData(mapOf(
                1 to UziData(2),
                3 to UziData(4),
            )),
            "map2" to UziData(mapOf(
                1 to UziData(2),
                3 to UziData(4),
            )),
        )),
        "map4" to UziData(mapOf(
            "map1" to UziData(mapOf(
                1 to UziData(2),
                3 to UziData(4),
            )),
            "map2" to UziData(mapOf(
                1 to UziData(2),
                3 to UziData(4),
            )),
        )),
        "map5" to UziData(mapOf(
            "map1" to UziData(mapOf(
                "map1" to UziData(mapOf(
                    1 to UziData(2),
                    3 to UziData(4),
                )),
                "map2" to UziData(mapOf(
                    1 to UziData(2),
                    3 to UziData(4),
                )),
            )),
            "map2" to UziData(mapOf(
                "map1" to UziData(mapOf(
                    1 to UziData(2),
                    3 to UziData(4),
                )),
                "map2" to UziData(mapOf(
                    1 to UziData(2),
                    3 to UziData(4),
                )),
            )),
        )),
        "map6" to UziData(mapOf(
            "map1" to UziData(mapOf(
                "map1" to UziData(mapOf(
                    1 to UziData(2),
                    3 to UziData(4),
                )),
                "map2" to UziData(mapOf(
                    1 to UziData(2),
                    3 to UziData(4),
                )),
            )),
            "map2" to UziData(mapOf(
                "map1" to UziData(mapOf(
                    1 to UziData(2),
                    3 to UziData(4),
                )),
                "map2" to UziData(mapOf(
                    1 to UziData(2),
                    3 to UziData(4),
                )),
            )),
        )),
    )).write().println()*/
    uziMap(
        "anvil_cost" to 4,
        "description" to uziMap(
            "translate" to "enchantment.minecraft.frost_walker"
        ),
        "effects" to uziMap(
            "damage_immunity" to uziList(
                uziMap(
                    "effect" to uziMap(),
                    "requirements" to uziMap(
                        "condition" to "damage_source_properties",
                        "predicate" to uziMap(
                            "tags" to uziList(
                                uziMap(
                                    "expected" to true,
                                    "id" to "burn_from_stepping"
                                ),
                                uziMap(
                                    "expected" to false,
                                    "id" to "bypasses_invulnerability"
                                )
                            )
                        )
                    )
                )
            ),
            "location_changed" to uziList(
                uziMap(
                    "effect" to uziMap(
                        "type" to "replace_disc",
                        "block_state" to uziMap(
                            "type" to "simple_state_provider",
                            "state" to uziMap(
                                "Name" to "frosted_ice",
                                "Properties" to uziMap(
                                    "age" to "0"
                                )
                            )
                        ),
                        "height" to 1,
                        "offset" to uziList(
                            0,
                            -1,
                            0
                        ),
                        "predicate" to uziMap(
                            "type" to "all_of",
                            "predicates" to uziList(
                                uziMap(
                                    "type" to "matching_blocks",
                                    "blocks" to "air",
                                    "offset" to uziList(
                                        0,
                                        1,
                                        0
                                    )
                                ),
                                uziMap(
                                    "type" to "matching_fluids",
                                    "fluids" to "water"
                                ),
                                uziMap(
                                    "type" to "unobstructed"
                                )
                            )
                        ),
                        "radius" to uziMap(
                            "type" to "clamped",
                            "max" to 16,
                            "min" to 0,
                            "value" to uziMap(
                                "type" to "linear",
                                "base" to 3,
                                "per_level_above_first" to 1
                            )
                        )
                    ),
                    "requirements" to uziMap(
                        "condition" to "entity_properties",
                        "entity" to "this",
                        "predicate" to uziMap(
                            "flags" to uziMap(
                                "is_on_ground" to true
                            )
                        )
                    )
                )
            )
        ),
        "exclusive_set" to "#exclusive_set/boots",
        "max_cost" to uziMap(
            "base" to 25,
            "per_level_above_first" to 10
        ),
        "max_level" to 2,
        "min_cost" to uziMap(
            "base" to 10,
            "per_level_above_first" to 10
        ),
        "slots" to uziList(
            "feet"
        ),
        "supported_items" to "#enchantable/foot_armor",
        "weight" to 2
    ).write().println()
    uziList(
        1, 2, 3,
        uziList(
            1,2,3
        ),
        uziList(
            1,2,3
        )
    ).write().println()
    println("END")
}
