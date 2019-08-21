# -*- coding: utf-8 -*-
"""
Created on Wed Aug 21 15:55:17 2019

@author: admin
"""

import jieba 
import jieba.analyse
import re
import pandas as pd
from sys import argv
s1= argv[1]
print (s1)
s='❤表白(.+?)❤'
b=re.compile(s)
c=list()
if len(s1)<1000:#小于1000个字就用原来的表白墙补充
    data=pd.read_csv(r"E:/同济表白墙采集1.csv",engine='python', encoding='utf8') 
    for a in data['字段1']:
        a=re.sub('[0-9]',"",a)
        c+=re.findall(b,a)
        a1=a.replace('❤',' ',1)
        c+=re.findall(b,a1)
    Str="".join(c)
    Str +=s1
else:
    Str=s1
    #tags = jieba.analyse.extract_tags(Str) 

words = jieba.lcut(Str)     # 使用精确模式对文本进行分词
counts = {}     # 通过键值对的形式存储词语及其出现的次数

for word in words:
    if len(word) == 1:    # 单个词语不计算在内
        continue
    else:
        counts[word] = counts.get(word, 0) + 1    # 遍历所有词语，每出现一次其对应的值加 1

items = list(counts.items())
items.sort(key=lambda x: x[1], reverse=True)    # 根据词语出现的次数进行从大到小排序
output=list()
for i in range(50):#显示的关键词数
    word, count = items[i]
    output.append(items[i])
    print("{0:<5}{1:>5}".format(word, count))
    
names=r'[李王张刘陈杨赵黄周吴徐孙胡朱高林何郭马罗梁宋郑谢韩唐冯于董萧程曹袁邓许傅沈曾彭吕苏卢蒋蔡贾丁魏薛叶阎余潘杜戴夏钟汪田任姜范方石姚谭廖邹熊金陆郝孔白崔康毛邱秦江史顾侯邵孟龙万段雷钱汤尹黎易常武乔贺赖龚文庞樊兰殷施陶宋体洪翟安颜倪严牛温芦季俞章鲁葛伍韦申尤毕聂丛焦向柳邢路岳齐沿梅莫庄辛管祝左涂谷祁时舒耿牟卜肖詹关苗凌费纪靳盛童欧甄项曲成游阳裴席卫查屈鲍位覃霍翁隋植甘景薄单包司柏宁柯阮桂闵欧阳解强柴华车冉房边净阴闫佘练宋体骆付代麦容悲初瞿褚班全名井米谈宫虞奚佟符蒲穆漆卞东储党从艾苻厉岑燕吉冷仇伊首郁娄楚邝历狄简胥连帅封危支原滕苑信索栗官沙池藏师国巩刁茅杭巫居窦皮戈麻饶习巴旷宗荆荣孝蔺廉员西寇刃见底区郦卓琚续朴蒙敖花应喻冀尚顿菅嵇雒弓忻权谌卿扈海冼伦鹿宿宋体山桑裘达么宣智尉迟东方幺郎农戚屠楼步鞠仲尉蓝招攀栾籍寿邬荚税逄加勾由福缑钦鲜于但邸逢况鄢古乐斯钮盖旦毅邰哈鄂商英迟仝亓玄黑腾晏禹诸苟湛殳亢奉占闻粟种匡宾劳申屠伏过水真宇巢计羌相辜展丑银丰矫上昝绳臧舍郅布糜乌衣来恒那满门司徒皋旺公言藤释尧缪干阚靖渠契晋六束良鹗贝邴沃竺扬励归上官荃焉多都果郜隆诸葛令狐慕礼祖翦力朗撖修呼富明站虢冶茹禚笪云肇平弋盘候尔姬宝畅冒邾延禅浦敬颉南巍补]'


nameletters1=r'[a-z][a-z]'
nameletters2=r'[a-z][a-z][a-z]'
import codecs

f = codecs.open('stopword.txt','r','utf-8-sig')

stopwords = f.readlines()

stopwords=[st[:-2] for st in stopwords]
print('红人')
for i in range(900):
    word, count = items[i]
    if ((re.match(names, items[i][0])) or (re.match(nameletters1, items[i][0])) or (re.match(nameletters2, items[i][0]))) and (word not in stopwords):
        print(items[i])
     


