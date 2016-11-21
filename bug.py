#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys
import time 
import urllib
import urllib2
import hashlib
import base64
import json
import sys
reload(sys)
sys.setdefaultencoding( "utf-8" )

def request(url,data):
    req = urllib2.Request(url = url, data = urllib.urlencode(data))
    res_data = urllib2.urlopen(req)
    res = res_data.read()
    return res

#获取货币对应的实时价格
#货币symbols:;USDCHF;USDJPY;USDCAD;GBPUSD;EURUSD;AUDUSD;NZDUSD;USDHKD;AUDCAD;AUDJPY;EURCAD;GBPAUD;GBPJPY
#黄金symbols:;GOLD;SILVER
#全球指数symbols:;NASX;SPX;HKSI;DOW;ESTX;CAC;DAX
#原油symbols:;WTI;BRENT
def GetSymbolTodayOpenPrice(symbols=';GOLD;SILVER'):
	url = "http://www.followme.com/Report/Symbol/GetSymbolTodayOpenPrice"
	data = {
		'brokerid':3,
		'symbols':symbols
	}
	res = request(url,data)
	#print(res)
	return json.loads(res,encoding='utf-8')

#获取交易员信息列表
#'ScreeningTime':1, 7,30,0)
#'PageOrderyFeild':'BizROI（收益率）,FollowProfit（跟随收益）,Point（盈亏点数）,FollowmeIndexEx(ME指标),Retracement（回撤率）
def GetRankJson(ScreeningTime=0,PageOrderyFeild='BizROI'):
	url = "http://www.followme.com/Report/Trader/GetRankJson"
	data = {
	'NickName':'',
	'OrderBy':'',
	'timeRange':0,
	'PageSize':15,
	'PageIndex':0,
	'IsPublish':1,
	'ScreeningTime':1, #(7,30,0全部)
	'ScreeningBroker':0,
	'PageOrderyFeild':'BizROI', #（收益率）（FollowProfit（跟随收益）,Point（盈亏点数）,FollowmeIndexEx(ME指标),Retracement（回撤率））
	'PageOrderyType':'sort_down'
	}
	res = request(url,data)
	#print(res)
	return json.loads(res,encoding='utf-8')

#获取交易动态
#PageIndex:
def GetDynamics(PageIndex=0):
	url = "http://www.followme.com/Report/Dynamic/GetDynamics"
	data = {
		'BrokerId':'',
		'OrderBy':'',
		'NickName':'',
		'profit':0,
		'PageSize':30,
		'PageIndex':1
	}
	res = request(url,data)
	#print(res)
	return json.loads(res,encoding='utf-8')

#获取交易员正在持有订单
#Cmd = '',0,1
def GetOpenOrders(id=74732,followAccountIndex=2,Cmd=''):
	url = "http://www.followme.com/Report/Customer/GetOpenedOrders"
	data = {
		'PageIndex':1,
		'PageSize':10,
		'OrderBy':'',
		'Cmd':Cmd,
		'openTime':'',
		'symbolType':'',
		'id':id,
		'followAccountIndex':'%d_%d'%(id,followAccountIndex)
	}
	res = request(url,data)
	#print(res)
	return json.loads(res,encoding='utf-8')


def GetClosedOrders(id=74732,followAccountIndex=2,Cmd=''):
	url = "http://www.followme.com/Report/Customer/GetClosedOrders"
	data = {
		'PageIndex':1,
		'PageSize':10,
		'OrderBy':'',
		'Cmd':Cmd,
		'openTime':'',
		'symbolType':'',
		'id':id,
		'followAccountIndex':'%d_%d'%(id,followAccountIndex)
	}
	res = request(url,data)
	#print(res)
	return json.loads(res,encoding='utf-8')

#获取外汇资讯
#categoryId：49(贵金属)，50（外汇）
def GetPostJsonList(categoryId=49):
	url = "http://www.followme.com/Post/GetPostJsonList"
	data = {
	'pageIndex':1,
	'pageSize':6,
	'categoryId':49 #(贵金属)，50（外汇）
	}
	res = request(url,data)
	#print(res)
	return json.loads(res,encoding='utf-8')

#获取财经日历
#beginDate='2016-11-20'
def GetLastFinancialCalendarData(beginDate='2016-11-20'):
	url = "http://www.followme.com/News/GetLastFinancialCalendarData"
	data = {
	'beginDate':"2016-11-20",
	'categories':[],
	'countries':[],
	'countryCode':"",
	'importances':[3,2,1],
	'keyWord':""
	}
	res = request(url,data)
	#print(res)
	return json.loads(res,encoding='utf-8')


data = GetSymbolTodayOpenPrice()
print(data)
data = GetRankJson()
print(data)
data = GetDynamics()
print(data)
data = GetOpenOrders()
print(data)
data = GetClosedOrders()
print(data)
data = GetPostJsonList()
print(data)
data = GetLastFinancialCalendarData()
print(data)



