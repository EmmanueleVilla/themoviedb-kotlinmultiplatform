package redux

import config.ConfigState

interface State

data class AppState(
    val configState: ConfigState = ConfigState()
) : State
