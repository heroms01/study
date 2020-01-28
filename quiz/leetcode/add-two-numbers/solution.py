class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

    def __str__(self):
    	chain = ''
    	dummy = self
    	while dummy:
    		chain += str(dummy.val) + '>'
    		dummy = dummy.next

    	return chain


# # badrabbit
# # runtime 68ms python
# class Solution(object):
#     def addTwoNumbers(self, l1, l2):
#         """
#         :type l1: ListNode
#         :type l2: ListNode
#         :rtype: ListNode
#         """
#         result = ListNode(0)
#         result_tail = result
#         carry = 0

#         while l1 or l2 or carry:
#             val1  = (l1.val if l1 else 0)
#             val2  = (l2.val if l2 else 0)
#             carry, out = divmod(val1+val2 + carry, 10)

#             result_tail.next = ListNode(out)
#             result_tail = result_tail.next

#             l1 = (l1.next if l1 else None)
#             l2 = (l2.next if l2 else None)

#         return result.next


# # MikeZLin
# # My Python3 Implementation - 102ms
# class Solution:
#     def addTwoNumbers(self, l1, l2 ,c = 0):
#         """
#         :type l1: ListNode
#         :type l2: ListNode
#         :rtype: ListNode
#         """
#         val = l1.val + l2.val + c
#         c = val // 10
#         ret = ListNode(val % 10 )

#         if (l1.next != None or l2.next != None or c != 0):
#             if l1.next == None:
#                 l1.next = ListNode(0)
#             if l2.next == None:
#                 l2.next = ListNode(0)
#             ret.next = self.addTwoNumbers(l1.next,l2.next,c)
#         return ret

def addTwoNumbers(l1: ListNode, l2: ListNode) -> ListNode:
	dummy = ListNode(0)
	curr = dummy
	carry = 0

	while l1 or l2:
		x = l1.val if l1 else 0
		y = l2.val if l2 else 0

		sum = carry + x + y
		carry = sum // 10
		curr.next = ListNode(sum % 10)
		curr = curr.next

		if l1 != None:
			l1 = l1.next
		if l2 != None:
			l2 = l2.next

	if carry > 0:
		curr.next = ListNode(carry)

	return dummy.next


l1 = ListNode(2)
l1.next = ListNode(4)
l1.next.next = ListNode(3)

l2 = ListNode(5)
l2.next = ListNode(6)
l2.next.next = ListNode(4)

print(addTwoNumbers(l1, l2))