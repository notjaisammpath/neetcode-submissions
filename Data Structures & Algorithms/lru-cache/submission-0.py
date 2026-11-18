class LRUCache:

    def __init__(self, capacity: int):
        self.map = {}
        self.head = LLNode()
        self.tail = LLNode()
        self.head.next = self.tail
        self.tail.prev = self.head
        self.cap = capacity

    def _remove(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev

    def _add_front(self, node):
        node.prev = self.head
        node.next = self.head.next
        self.head.next.prev = node
        self.head.next = node

    def get(self, key: int) -> int:
        if key in self.map:
            node = self.map[key]
            self._remove( node)
            self._add_front( node)
            return node.val
        else:
            return -1
        

    def put(self, key: int, value: int) -> None:
        n = LLNode(key, value)
        if key in self.map: 
            self._remove( self.map[key])
            self._add_front( n)
            self.map[key] = n

        else:
            if len(self.map) < self.cap:
                self._add_front(n)
                self.map[key] = n
            else:
                toRem = self.tail.prev
                self.map.pop(toRem.key)
                self._remove( toRem)
                self._add_front( n)
                self.map[key] = n



        

class LLNode:
    def __init__ (self, key=0, val=0):
        self.key, self.val = key, val
        self.prev = None
        self.next = None
        
