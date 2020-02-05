# -*- coding: utf-8 -*-
import json

path = 'D:/source/private/study/books/python-for-data-analysis/example.txt'
records = [json.loads(line) for line in open(path)]

time_zones = [rec['tz'] for rec in records if 'tz' in rec]  # 표준시간대


# 표준시간대 세기
def get_counts(sequence):
	counts = {}
	for x in sequence:
		if x in counts:
			counts[x] += 1
		else:
			counts[x] = 1
	return counts


counts = get_counts(time_zones)

# 파이썬 표준 라이브러리 표준시간대 세기
from collections import defaultdict


def get_counts2(sequence):
	counts = defaultdict(int)
	for x in sequence:
		counts[x] += 1
	return counts


counts = get_counts2(time_zones)

counts['America/New_York']
len(time_zones)


# 상위 10개 표준시간대 가져오기
def top_counts(count_dict, n=10):
	value_key_pairs = [(count, tz) for tz, count in count_dict.items()]
	value_key_pairs.sort()
	return value_key_pairs[-n:]


top_counts(counts)

# 파이썬 표준 라이브러리 상위 10개 가져오기
from collections import Counter

counts = Counter(time_zones)
counts.most_common(10)

# pandas로 표준시간대 세기
from pandas import DataFrame, Series
import pandas as pd

frame = DataFrame(records)

# frame.info()  # DataFrame 객체 요약 정보 보기
# frame['tz'][:10]
tz_counts = frame['tz'].value_counts()
tz_counts[:10]

# matplotlib 라이브러리 사용하여 그래프 그리기
clean_tz = frame['tz'].fillna('Missing')  # 없는 값 대체
clean_tz[clean_tz == ''] = 'Unknown'  # 비어있는 값 불리언 배열 색인 이용 대체
tz_counts = clean_tz.value_counts()
tz_counts[:10].plot(kind='barh', rot=0)

# 브라우저 종류 가져오기
results = Series([x.split()[0] for x in frame.a.dropna()])
