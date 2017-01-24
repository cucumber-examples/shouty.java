#!/bin/bash

docker build -t shouty.java .

docker run -it -v `pwd`:/shouty.java shouty.java /bin/bash
