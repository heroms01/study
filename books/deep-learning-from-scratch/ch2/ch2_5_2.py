from ch2_3_3 import AND, NAND, OR


def XOR(x1, x2):
	s1 = NAND(x1, x2)
	s2 = OR(x1, x2)
	return AND(s1, s2)


print(XOR(0, 0))
print(XOR(0, 1))
print(XOR(1, 0))
print(XOR(1, 1))

