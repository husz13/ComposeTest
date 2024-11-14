package com.hus.xo

sealed class UserAction{

    object ResetButtonClicked : UserAction()
    data class BoardTapped(val cellNo :Int) :UserAction()

}