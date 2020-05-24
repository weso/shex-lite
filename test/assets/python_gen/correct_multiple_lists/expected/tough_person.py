from dataclasses import dataclass

from typing import Any

from typing import List

@dataclass
class Person:
	has_name: str
	has_surname: str
	has_addresses: List[str]

@dataclass
class Toughperson:
	has_friends: List[Person]
	has_enemies: List[Person]

