# Compare CPU impact of Spring RequestParam on 5.1 vs 5.2
[![Build Status](https://travis-ci.org/jensim/spring-boot-compare-22-21.svg?branch=master)](https://travis-ci.org/jensim/spring-boot-compare-22-21)

Im trying to illustrate a very noticeable increase in CPU usage moving from v5.1 to v5.2
![GET 2.1 with defaults](./images/21%20Screen%20Shot%202020-04-23%20at%2011.15.58.png)
![GET 2.2 with defaults](./images/22%20Screen%20Shot%202020-04-23%20at%2011.18.29.png)

We recently (tried to) upgrade one of our services in production, but rolled back once we noticed a rough doubling in CPU usage on the upgraded JVMs.
The service in question handles a lot of requests, but doesn't do very much on its own, just some fanning out and collecting data from other services.

In this repo I've tried to set up two applications with as little stuff as possible, but to be fairly similar to the application that we upgraded in RequestParmeters. 

We spent a ton of time trying to figure out what was wrong, *JDK Mission Control* pointed us at `TypeMappedAnnotation.getValue(int,boolean,boolean)`. 
We are no spring experts, we only noticed it was new with SpringFramework 5.2.
![JMC](./images/Screen%20Shot%202020-04-22%20at%2009.50.23.png) 

The CPU increase is roughly double, but only when we have an access logging filter active, otherwise the increase in CPU is less.

## Conclusion
SpringFramework 5.2 has a regression in CPU performance when dealing with `RequestParameter`s with default values in combination with having a `Filter` that looks at the `HttpServletRequest` & `HttpServletResponse` (AccessLogging). The impact on CPU is massive when upgrading from `5.1` to `5.2`.
