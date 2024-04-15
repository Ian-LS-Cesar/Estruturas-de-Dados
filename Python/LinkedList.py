
class Node:
    def __init__(self, data):
        self.data = data 
        self.next = None

    def insertAtStart(self, data):
        newNode = Node(data)
        if self.head is None:
            self.head = NewNode
            return
        else:
            newNode.next = self.head
            self.head = newNode
    
    def insertByIndex(self, data, index):
        newNode = Node(data)
        currentNode = self.head
        position = 0

        if position == index:
            self.insertStart(data)
        else:
            while(currentNode != None and (position + 1) != index ):
                position+=1
                currentNode = currentNode.next

            if currentNode != None:
                newNode.next = currentNode.next
                currentNode.next = newNode
            else:
                raise("Index out of bounds!!!")
    
    def add(self, data):
        newNode = Node(data)
        if self.head is None:
            self.head = newNode
            return
        
        currentNode = self.head
        while(currentNode.next):
            currentNode = currentNode.next
        
        currentNode.next = newNode

    def set(self, value, index):
        currentNode = self.head
        position = 0

        if position == index:
            currentNode.data = value
        else:
            while (currentNode != None and position != index):
                position+=1
                currentNode = currentNode.next
            
            if currentNode != None:
                currentNode.data = value
            else:
                raise ("Index out of bounds!!!")
    
    def removeFirst(self):
        if(self.head == None):
            return

        self.head = self.head.next

    def removeLast(self):
        if (self.head is None):
            return

        currentNode = self.head
        while(currentNode.next.next):
            currentNode = currentNode.next
        
        currentNode.next = None

    def removeByIndex(self, index):
        if self.head == None:
            return
        
        currentNode = self.head
        position = 0
        if position == index:
            self.removeFirst()
        else:
            while(currentNode != None and (position + 1) != index):
                position+=1
                currentNode = currentNode.next

            if currentNode != None:
                currentNode.next = currentNode.next.next
            else:
                raise("Index out of Bounds")
    
    def removeNode(self, data):
        currentNode = self.head 

        if currentNode.data == data:
            self.removeFirst
            return
        
        while currentNode is not None and currentNode.next.data != data:
            currentNode = currentNode.next
        
        if currentNode is None:
            return 
        else:
            currentNode.next = currentNode.next.next
            
    def size(self):
        size = 0
        if (self.head):
            currentNode = self.head
            while(currentNode):
                size+=1
                currentNode = currentNode.next
            return size
        else:
            return 0
    