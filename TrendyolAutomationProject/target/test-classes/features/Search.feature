Feature: Trendyol Search Function

  Scenario Outline: User searches for "Kablosuz kulaklık"
    Given User goes to Trendyol home page
    When User searches for <product>
    Then Search results must include "Kablosuz kulaklık"

    Examples:
      | product             |
      | "Kablosuz kulaklık" |
