
#!/bin/bash

#ABI=armaebi-v7a
ABI=x86
#ABI=arm64-v8a
#ABI=x86_64

ANDROID_NDK=$HOME/Android/Sdk/ndk/21.1.6352462
TOOL_CHAIN=${ANDROID_NDK}/build/cmake/android.toolchain.cmake
CMAKE=$HOME/Android/Sdk/cmake/3.18.1/bin/cmake

mkdir -p ${ABI}
cd ${ABI}

${CMAKE} ../../mbedtls -DCMAKE_SYSTEM_NAME=Android -DCMAKE_SYSTEM_VERSION=21 \
-DANDROID_ABI=${ABI} -DCMAKE_TOOLCHAIN_FILE=${TOOL_CHAIN} \
-DUSE_SHARED_MBEDTLS_LIBRARY=On -DENABLE_TESTING=Off
# -DCMAKE_CXX_FLAGS=-DSPDLOG_COMPILED_LIBS

${CMAKE} --build .