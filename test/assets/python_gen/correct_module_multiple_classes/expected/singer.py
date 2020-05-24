from dataclasses import dataclass

from datetime import date

from datetime import time

from typing import Any

from typing import List

@dataclass
class Song:
	title: str
	release_date: date
	number_of_plays: int
	length: time

@dataclass
class Singer:
	name: str
	surname: str
	age: int
	has_songs: List[Song]

