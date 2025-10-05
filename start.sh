#!/bin/bash
# Force Java stdout/stderr to be unbuffered
exec stdbuf -o0 -e0 java -jar app.jar
