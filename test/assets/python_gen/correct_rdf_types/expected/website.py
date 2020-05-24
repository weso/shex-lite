from dataclasses import dataclass

from typing import Any

from typing import List

from xml.dom.minidom import Document

from xml.dom.minidom import DocumentFragment

@dataclass
class Webpage:
	document: Document
	fragments: List[DocumentFragment]

@dataclass
class Website:
	pages: List[Webpage]

