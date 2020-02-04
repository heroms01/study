a = 11
b = 5

print('a :', bin(a))
print('b :', bin(b))

print('기본 비트 연산')
print('a & b :', bin(a&b))
print('a | b :', bin(a|b))
print('a ^ b :', bin(a^b))
print('~a :', bin(~a))
print('a << b :', bin(a<<b))
print('a >> b :', bin(a>>b))

print('--------------------')
print('20개 비트 모두 켜기')
full_pizza = (1 << 20) - 1
print(bin(full_pizza))

print('원소 추가')
toppings = 0 
pepperoni = 2
cheese = 3
toppings |= (1 << pepperoni)
print(bin(toppings))
toppings |= (1 << cheese)
print(bin(toppings))

print('원소 포함 여부 확인')
if toppings & (1 << pepperoni):
    print('페퍼로니 포함')

print('원소 삭제')
# 이미 페퍼로니가 있을때만 가능, 없을때 사용하면 오류 
toppings -= (1 << pepperoni)
print(bin(toppings))
# 안전한 코드 
toppings &= ~(1 << pepperoni)
print(bin(toppings))

print('원소 토글')
toppings ^= (1 << pepperoni)
print(bin(toppings))


