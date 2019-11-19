import numpy as np

"""
넘파이 배열 생성
"""
x = np.array([1.0, 2.0, 3.0])
print(x)
print(type(x))
print('---')

"""
넘파이 배열 산술 연산
원소수가 다르면 오류 
"""
x = np.array([1.0, 2.0, 3.0])
y = np.array([2.0, 4.0, 6.0])
print(x + y)
print(x - y)
print(x * y)
print(x / y)
print('---')

"""
브로드캐스트 기능
넘파이 배열과 수치 하나의 산술 연산
"""
x = np.array([1.0, 2.0, 3.0])
print(x / 2.0)
print('---')

"""
N차원 배열
"""
x = np.array([[1, 2], [3, 4]])
print(x)
print(x.shape)  # 각 차원의 크기
print(x.dtype)  # 원소의 자료형

y = np.array([[3, 0], [0, 4]])
print(x+y)
print(x*y)
print(x*10)  # 브로드캐스트
print('---')


"""
브로드캐스트
"""
x = np.array([[1, 2], [3, 4]])
y = np.array([10, 20])
print(x*y)
print('---')

"""
원소 접근
"""
x = np.array([[51, 55], [14, 19], [0, 4]])
print(x[0])
print(x[0][1])
print('---')

for row in x:
	print(row)
print('---')

# x를 1차원 배열로 변환(평탄화)
y = x.flatten()
print(y)
# 다중 인덱스 접근
print(y[np.array([0, 2, 4])])
# 조건 만족
print(y > 15)
print(y[y > 15])
print('---')
