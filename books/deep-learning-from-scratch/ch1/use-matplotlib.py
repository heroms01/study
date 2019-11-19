import numpy as np
import matplotlib.pyplot as plt
from matplotlib.image import imread

"""
단순 그래프
"""
x = np.arange(0, 6, 0.1)  # 0에서 6까지 0.1 간격으로 생성
y = np.sin(x)

plt.plot(x, y)
plt.show()
print('---')

"""
상세 그래프
"""
x = np.arange(0, 6, 0.1)  # 0에서 6까지 0.1 간격으로 생성
y1 = np.sin(x)
y2 = np.cos(x)

plt.plot(x, y1, label="sin")
plt.plot(x, y2, label="cos", linestyle="--")
plt.xlabel("x")
plt.ylabel("y")
plt.title("sin & cos")
plt.legend()
plt.show()
print('---')

"""
이미지 표시
"""
img = imread('../resource/pawns.jpg')
plt.imshow(img)
plt.show()


