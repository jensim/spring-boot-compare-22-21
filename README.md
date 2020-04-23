# Compare CPU impact of Spring RequestParam on 5.1 vs 5.2
[![Build Status](https://travis-ci.org/jensim/spring-boot-compare-22-21.svg?branch=master)](https://travis-ci.org/jensim/spring-boot-compare-22-21)

Im trying to illustrate a very noticeable increase in CPU usage moving from v5.1 to v5.2

## 2.1
![GET 2.1](./images/with%20defaults%20spring%202.1%20Screen%20Shot%202020-04-23%20at%2009.07.11.png)

## 2.2
![GET 2.2](./images/with%20defaults%20spring%202.2%20Screen%20Shot%202020-04-23%20at%2009.10.02.png)

We recently (tried to) upgrade one of our services in production, but rolled back once we noticed a rough doubling in CPU usage on the upgraded JVMs

In this repo I've tried to set up two applications with as little stuff as possible, but to be fairly similar to the application that we upgraded in RequestParmeters 

We spent a ton of time trying to figure out what was wrong, *JDK Mission Control* pointed us at `TypeMappedAnnotation.getValue(int,boolean,boolean)`. 
We are no spring experts, we only noticed it was new with 5.2.
![JMC](./images/Screen%20Shot%202020-04-22%20at%2009.50.23.png) 

Something was probably improved with this feature, but it also seems to have affected performance of RequestParams for the worse.
