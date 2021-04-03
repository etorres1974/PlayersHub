package br.com.playershub.data.rawgGamesApi.entity

enum class Ordering(value : String) {
    NAME("name"),
    RELEASED("released"),
    ADDED("added"),
    I_ADDED("-added"),
    CREATED("created"),
    UPDATED("updated"),
    RATING("rating"),
    METACRITIC("metacritic")
}