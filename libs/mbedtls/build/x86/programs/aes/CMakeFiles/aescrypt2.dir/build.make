# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.18

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Disable VCS-based implicit rules.
% : %,v


# Disable VCS-based implicit rules.
% : RCS/%


# Disable VCS-based implicit rules.
% : RCS/%,v


# Disable VCS-based implicit rules.
% : SCCS/s.%


# Disable VCS-based implicit rules.
% : s.%


.SUFFIXES: .hpux_make_needs_suffix_list


# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /home/trunqh/Android/Sdk/cmake/3.18.1/bin/cmake

# The command to remove a file.
RM = /home/trunqh/Android/Sdk/cmake/3.18.1/bin/cmake -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/mbedtls

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86

# Include any dependencies generated for this target.
include programs/aes/CMakeFiles/aescrypt2.dir/depend.make

# Include the progress variables for this target.
include programs/aes/CMakeFiles/aescrypt2.dir/progress.make

# Include the compile flags for this target's objects.
include programs/aes/CMakeFiles/aescrypt2.dir/flags.make

programs/aes/CMakeFiles/aescrypt2.dir/aescrypt2.c.o: programs/aes/CMakeFiles/aescrypt2.dir/flags.make
programs/aes/CMakeFiles/aescrypt2.dir/aescrypt2.c.o: /home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/mbedtls/programs/aes/aescrypt2.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object programs/aes/CMakeFiles/aescrypt2.dir/aescrypt2.c.o"
	cd /home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86/programs/aes && /home/trunqh/Android/Sdk/ndk/21.1.6352462/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=i686-none-linux-android16 --gcc-toolchain=/home/trunqh/Android/Sdk/ndk/21.1.6352462/toolchains/llvm/prebuilt/linux-x86_64 --sysroot=/home/trunqh/Android/Sdk/ndk/21.1.6352462/toolchains/llvm/prebuilt/linux-x86_64/sysroot $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/aescrypt2.dir/aescrypt2.c.o -c /home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/mbedtls/programs/aes/aescrypt2.c

programs/aes/CMakeFiles/aescrypt2.dir/aescrypt2.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/aescrypt2.dir/aescrypt2.c.i"
	cd /home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86/programs/aes && /home/trunqh/Android/Sdk/ndk/21.1.6352462/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=i686-none-linux-android16 --gcc-toolchain=/home/trunqh/Android/Sdk/ndk/21.1.6352462/toolchains/llvm/prebuilt/linux-x86_64 --sysroot=/home/trunqh/Android/Sdk/ndk/21.1.6352462/toolchains/llvm/prebuilt/linux-x86_64/sysroot $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/mbedtls/programs/aes/aescrypt2.c > CMakeFiles/aescrypt2.dir/aescrypt2.c.i

programs/aes/CMakeFiles/aescrypt2.dir/aescrypt2.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/aescrypt2.dir/aescrypt2.c.s"
	cd /home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86/programs/aes && /home/trunqh/Android/Sdk/ndk/21.1.6352462/toolchains/llvm/prebuilt/linux-x86_64/bin/clang --target=i686-none-linux-android16 --gcc-toolchain=/home/trunqh/Android/Sdk/ndk/21.1.6352462/toolchains/llvm/prebuilt/linux-x86_64 --sysroot=/home/trunqh/Android/Sdk/ndk/21.1.6352462/toolchains/llvm/prebuilt/linux-x86_64/sysroot $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/mbedtls/programs/aes/aescrypt2.c -o CMakeFiles/aescrypt2.dir/aescrypt2.c.s

# Object files for target aescrypt2
aescrypt2_OBJECTS = \
"CMakeFiles/aescrypt2.dir/aescrypt2.c.o"

# External object files for target aescrypt2
aescrypt2_EXTERNAL_OBJECTS = \
"/home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86/CMakeFiles/mbedtls_test.dir/tests/src/asn1_helpers.c.o" \
"/home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86/CMakeFiles/mbedtls_test.dir/tests/src/drivers/cipher.c.o" \
"/home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86/CMakeFiles/mbedtls_test.dir/tests/src/drivers/key_management.c.o" \
"/home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86/CMakeFiles/mbedtls_test.dir/tests/src/drivers/signature.c.o" \
"/home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86/CMakeFiles/mbedtls_test.dir/tests/src/drivers/size.c.o" \
"/home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86/CMakeFiles/mbedtls_test.dir/tests/src/fake_external_rng_for_test.c.o" \
"/home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86/CMakeFiles/mbedtls_test.dir/tests/src/helpers.c.o" \
"/home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86/CMakeFiles/mbedtls_test.dir/tests/src/psa_crypto_helpers.c.o" \
"/home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86/CMakeFiles/mbedtls_test.dir/tests/src/psa_exercise_key.c.o" \
"/home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86/CMakeFiles/mbedtls_test.dir/tests/src/random.c.o" \
"/home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86/CMakeFiles/mbedtls_test.dir/tests/src/threading_helpers.c.o"

programs/aes/aescrypt2: programs/aes/CMakeFiles/aescrypt2.dir/aescrypt2.c.o
programs/aes/aescrypt2: CMakeFiles/mbedtls_test.dir/tests/src/asn1_helpers.c.o
programs/aes/aescrypt2: CMakeFiles/mbedtls_test.dir/tests/src/drivers/cipher.c.o
programs/aes/aescrypt2: CMakeFiles/mbedtls_test.dir/tests/src/drivers/key_management.c.o
programs/aes/aescrypt2: CMakeFiles/mbedtls_test.dir/tests/src/drivers/signature.c.o
programs/aes/aescrypt2: CMakeFiles/mbedtls_test.dir/tests/src/drivers/size.c.o
programs/aes/aescrypt2: CMakeFiles/mbedtls_test.dir/tests/src/fake_external_rng_for_test.c.o
programs/aes/aescrypt2: CMakeFiles/mbedtls_test.dir/tests/src/helpers.c.o
programs/aes/aescrypt2: CMakeFiles/mbedtls_test.dir/tests/src/psa_crypto_helpers.c.o
programs/aes/aescrypt2: CMakeFiles/mbedtls_test.dir/tests/src/psa_exercise_key.c.o
programs/aes/aescrypt2: CMakeFiles/mbedtls_test.dir/tests/src/random.c.o
programs/aes/aescrypt2: CMakeFiles/mbedtls_test.dir/tests/src/threading_helpers.c.o
programs/aes/aescrypt2: programs/aes/CMakeFiles/aescrypt2.dir/build.make
programs/aes/aescrypt2: library/libmbedcrypto.so
programs/aes/aescrypt2: programs/aes/CMakeFiles/aescrypt2.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable aescrypt2"
	cd /home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86/programs/aes && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/aescrypt2.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
programs/aes/CMakeFiles/aescrypt2.dir/build: programs/aes/aescrypt2

.PHONY : programs/aes/CMakeFiles/aescrypt2.dir/build

programs/aes/CMakeFiles/aescrypt2.dir/clean:
	cd /home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86/programs/aes && $(CMAKE_COMMAND) -P CMakeFiles/aescrypt2.dir/cmake_clean.cmake
.PHONY : programs/aes/CMakeFiles/aescrypt2.dir/clean

programs/aes/CMakeFiles/aescrypt2.dir/depend:
	cd /home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86 && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/mbedtls /home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/mbedtls/programs/aes /home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86 /home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86/programs/aes /home/trunqh/AndroidStudioProjects/rpo_fclient/libs/mbedtls/build/x86/programs/aes/CMakeFiles/aescrypt2.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : programs/aes/CMakeFiles/aescrypt2.dir/depend

