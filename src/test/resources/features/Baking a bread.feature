Feature: We describe scenarios for baking a bread

	Scenario: H1 We bake a bread
		Given we have made bread dough
		When we bake the dough
		Then the bread is baked

	Scenario Outline: H2 We bake a bread for different duration
		Given we have made bread dough
		When we bake the dough for <bakeDuration> minutes
		Then the bread is baked
		Examples:
			| bakeDuration |
			| 5            |
			| 10           |

	#todo extract background
