// Copyright 2023 Nacho Lopez
// SPDX-License-Identifier: Apache-2.0
package io.nlopez.compose.rules.detekt

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Debt
import io.gitlab.arturbosch.detekt.api.Issue
import io.gitlab.arturbosch.detekt.api.Severity
import io.nlopez.compose.core.ComposeKtVisitor
import io.nlopez.compose.rules.DetektRule
import io.nlopez.compose.rules.RememberStateMissing

class RememberStateMissingCheck(config: Config) :
    DetektRule(config),
    ComposeKtVisitor by RememberStateMissing() {

    override val issue: Issue = Issue(
        id = "RememberMissing",
        severity = Severity.Defect,
        description = """
            Using mutableStateOf/derivedStateOf in a @Composable function without it being inside of a remember function.
            If you don't remember the state instance, a new state instance will be created when the function is recomposed.
        """.trimIndent(),
        debt = Debt.FIVE_MINS,
    )
}
