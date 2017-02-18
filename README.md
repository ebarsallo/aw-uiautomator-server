# Android Wear (AW) UIAutomator Server

An extension of [UIAutomator Server](https://github.com/xiaocong/android-uiautomator-server),
with support to Android Wear.

# Purpose

[UI Automator](https://developer.android.com/training/testing/ui-testing/uiautomator-testing.html) is a
tool to perform Android UI testing for multiple devices. UIAutomator Server allows
developers to write Python scripts to communicate with Android handheld devices, but not applicable for
Android Wear (AW). 

This project is to extend the original UIAutomator Server to support AW. It reuses the JSONRPC
server in a separate `wear` module which could be loaded into AW devices. Developers
can control both the handhelds and the wearables with a single Python script.

# Build

- Run command:

        $ ./gradlew build
        $ ./gradlew packageDebugAndroidTest

# How to use

Refer to python wrapper library [uiautomator](https://github.com/xiaocong/uiautomator).

# Notes

If you have any questions or ideas, please [create a new issue](https://github.com/presto-osu/aw-uiautomator-server/issues/new).
