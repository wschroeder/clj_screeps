# clj_screeps

This project demonstrates my efforts in using ClojureScript to play the
Screeps game.

## credentials.js

You need to create a credentials.js in the toplevel directory of this
repository.  For the free sandbox version of Screeps, use the following
configuration, replacing EMAIL with your Screeps account email and PASSWORD
with your account password:

    module.exports = {
        email: 'EMAIL',
        password: 'PASSWORD',
        branch: 'default',
        ptr: false
    };

## Working with Make

To just build the project:

    make

To release to Screeps:

    make release

To start afresh:

    make clean

To really start afresh, removing even the installed node modules:

    make clean_all

