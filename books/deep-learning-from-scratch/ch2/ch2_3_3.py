"""
# 가중치와 편향 도입
세타를 -b로 치환
y = 0 = (b + w1*x1 + w2*x2 <= 0)
y = 1 = (b + w1*x1 + w2*x2 > 0)
b가 편향(bias)
"""

import numpy as np


def AND(x1, x2):
    """
    세타가 편향으로 치환됨
    가중치는 각 입력 신호가 결과에 주는 영향력(중요도)을 조절하는 매개변수
    편향은 뉴런이 얼마나 쉽게 활성화(결과로 1을 출력)하느냐를 조정하는 매개변수
    """
    x = np.array([x1, x2])
    w = np.array([0.5, 0.5])
    b = -0.7
    tmp = np.sum(w*x) + b
    if tmp <= 0:
        return 0
    else:
        return 1


def NAND(x1, x2):
    x = np.array([x1, x2])
    w = np.array([-0.5, -0.5])
    b = 0.7
    tmp = np.sum(w*x) + b
    if tmp <= 0:
        return 0
    else:
        return 1


def OR(x1, x2):
    x = np.array([x1, x2])
    w = np.array([0.5, 0.5])
    b = -0.2
    tmp = np.sum(w*x) + b
    if tmp <= 0:
        return 0
    else:
        return 1


if __name__ == '__main__':
    print(AND(0, 0))
    print(AND(1, 0))
    print(AND(0, 1))
    print(AND(1, 1))
    print('---')
    print(NAND(0, 0))
    print(NAND(1, 0))
    print(NAND(0, 1))
    print(NAND(1, 1))
    print('---')
    print(OR(0, 0))
    print(OR(1, 0))
    print(OR(0, 1))
    print(OR(1, 1))