FROM maven:3-jdk-8-alpine

RUN addgroup -g 1000 shouty \
    && adduser -u 1000 -G shouty -s /bin/bash -D shouty

USER shouty

WORKDIR /shouty.java
