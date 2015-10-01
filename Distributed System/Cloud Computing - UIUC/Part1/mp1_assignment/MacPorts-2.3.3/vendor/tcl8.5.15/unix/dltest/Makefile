# This Makefile is used to create several test cases for Tcl's load
# command.  It also illustrates how to take advantage of configuration
# exported by Tcl to set up Makefiles for shared libraries.

CC = gcc
LIBS =			-L/Users/Jiangyuhang/Desktop/interview/Distributed\ System/Cloud\ Computing\ -\ UIUC/Part1/mp1_assignment/MacPorts-2.3.3/vendor/tcl8.5.15/unix -ltclstub8.5   -lpthread -framework CoreFoundation 
AC_FLAGS =		-DPACKAGE_NAME=\"tcl\" -DPACKAGE_TARNAME=\"tcl\" -DPACKAGE_VERSION=\"8.5\" -DPACKAGE_STRING=\"tcl\ 8.5\" -DPACKAGE_BUGREPORT=\"\" -DSTDC_HEADERS=1 -DHAVE_SYS_TYPES_H=1 -DHAVE_SYS_STAT_H=1 -DHAVE_STDLIB_H=1 -DHAVE_STRING_H=1 -DHAVE_MEMORY_H=1 -DHAVE_STRINGS_H=1 -DHAVE_INTTYPES_H=1 -DHAVE_STDINT_H=1 -DHAVE_UNISTD_H=1 -DNO_VALUES_H=1 -DHAVE_LIMITS_H=1 -DHAVE_SYS_PARAM_H=1 -DUSE_THREAD_ALLOC=1 -D_REENTRANT=1 -D_THREAD_SAFE=1 -DHAVE_PTHREAD_ATTR_SETSTACKSIZE=1 -DHAVE_PTHREAD_ATFORK=1 -DHAVE_PTHREAD_GET_STACKSIZE_NP=1 -DTCL_THREADS=1 -DTCL_CFGVAL_ENCODING=\"iso8859-1\" -DMODULE_SCOPE=extern\ __attribute__\(\(__visibility__\(\"hidden\"\)\)\) -DMAC_OSX_TCL=1 -DHAVE_COREFOUNDATION=1 -DHAVE_CAST_TO_UNION=1 -DTCL_SHLIB_EXT=\".dylib\" -DNDEBUG=1 -DTCL_CFG_OPTIMIZED=1 -DTCL_TOMMATH=1 -DMP_PREC=4 -DTCL_WIDE_INT_IS_LONG=1 -DHAVE_GETCWD=1 -DHAVE_OPENDIR=1 -DHAVE_STRTOL=1 -DHAVE_WAITPID=1 -DHAVE_GETADDRINFO=1 -DHAVE_GETPWUID_R_5=1 -DHAVE_GETPWUID_R=1 -DHAVE_GETPWNAM_R_5=1 -DHAVE_GETPWNAM_R=1 -DHAVE_GETGRGID_R_5=1 -DHAVE_GETGRGID_R=1 -DHAVE_GETGRNAM_R_5=1 -DHAVE_GETGRNAM_R=1 -DHAVE_MTSAFE_GETHOSTBYNAME=1 -DHAVE_MTSAFE_GETHOSTBYADDR=1 -DHAVE_SYS_TIME_H=1 -DTIME_WITH_SYS_TIME=1 -DHAVE_GMTIME_R=1 -DHAVE_LOCALTIME_R=1 -DHAVE_MKTIME=1 -DHAVE_TM_GMTOFF=1 -DHAVE_TIMEZONE_VAR=1 -DHAVE_STRUCT_STAT_ST_BLOCKS=1 -DHAVE_STRUCT_STAT_ST_BLKSIZE=1 -DHAVE_BLKCNT_T=1 -DHAVE_INTPTR_T=1 -DHAVE_UINTPTR_T=1 -DHAVE_SIGNED_CHAR=1 -DHAVE_LANGINFO=1 -DHAVE_CHFLAGS=1 -DHAVE_GETATTRLIST=1 -DHAVE_COPYFILE_H=1 -DHAVE_COPYFILE=1 -DHAVE_LIBKERN_OSATOMIC_H=1 -DHAVE_OSSPINLOCKLOCK=1 -DUSE_VFORK=1 -DTCL_DEFAULT_ENCODING=\"utf-8\" -DTCL_LOAD_FROM_MEMORY=1 -DTCL_WIDE_CLICKS=1 -DHAVE_AVAILABILITYMACROS_H=1 -DHAVE_WEAK_IMPORT=1 -D_DARWIN_C_SOURCE=1 -DHAVE_FTS=1 -DHAVE_SYS_IOCTL_H=1 -DHAVE_SYS_FILIO_H=1 -DTCL_UNLOAD_DLLS=1 -DHAVE_CPUID=1 
SHLIB_LD =		${CC} -dynamiclib ${CFLAGS} ${LDFLAGS} -Wl,-single_module
SHLIB_CFLAGS =		-fno-common
SHLIB_LD_LIBS =		${LIBS}
SHLIB_SUFFIX =		.dylib
DLTEST_LD =		${CC} -bundle -Wl,-w ${CFLAGS} ${LDFLAGS}
DLTEST_SUFFIX =		.bundle
SRC_DIR =		/Users/Jiangyuhang/Desktop/interview/Distributed System/Cloud Computing - UIUC/Part1/mp1_assignment/MacPorts-2.3.3/vendor/tcl8.5.15/unix/dltest
BUILD_DIR =		.
TCL_VERSION=		8.5

CFLAGS_DEBUG		= -g
CFLAGS_OPTIMIZE		= -Os
CFLAGS			= $(CFLAGS_OPTIMIZE) -pipe   
LDFLAGS_DEBUG		= 
LDFLAGS_OPTIMIZE	= 
LDFLAGS			= $(LDFLAGS_OPTIMIZE)  -prebind -headerpad_max_install_names -Wl,-search_paths_first 

CC_SWITCHES = $(CFLAGS) -I${SRC_DIR}/../../generic -I${BUILD_DIR}/.. -DTCL_MEM_DEBUG \
	${SHLIB_CFLAGS} -DUSE_TCL_STUBS ${AC_FLAGS}

all: pkga${SHLIB_SUFFIX} pkgb${SHLIB_SUFFIX} pkgc${SHLIB_SUFFIX} pkgd${SHLIB_SUFFIX} pkge${SHLIB_SUFFIX} pkgua${SHLIB_SUFFIX}
	@if test -n "$(DLTEST_SUFFIX)"; then $(MAKE) dltest_suffix; fi
	@touch ../dltest.marker

dltest_suffix: pkga${DLTEST_SUFFIX} pkgb${DLTEST_SUFFIX} pkgc${DLTEST_SUFFIX} pkgd${DLTEST_SUFFIX} pkge${DLTEST_SUFFIX} pkgua${DLTEST_SUFFIX}
	@touch ../dltest.marker

pkga.o: $(SRC_DIR)/pkga.c
	$(CC) -c $(CC_SWITCHES) $(SRC_DIR)/pkga.c

pkgb.o: $(SRC_DIR)/pkgb.c
	$(CC) -c $(CC_SWITCHES) $(SRC_DIR)/pkgb.c

pkgc.o: $(SRC_DIR)/pkgc.c
	$(CC) -c $(CC_SWITCHES) $(SRC_DIR)/pkgc.c

pkgd.o: $(SRC_DIR)/pkgd.c
	$(CC) -c $(CC_SWITCHES) $(SRC_DIR)/pkgd.c

pkge.o: $(SRC_DIR)/pkge.c
	$(CC) -c $(CC_SWITCHES) $(SRC_DIR)/pkge.c

pkgua.o: $(SRC_DIR)/pkgua.c
	$(CC) -c $(CC_SWITCHES) $(SRC_DIR)/pkgua.c

pkga${SHLIB_SUFFIX}: pkga.o
	${SHLIB_LD} -o pkga${SHLIB_SUFFIX} pkga.o ${SHLIB_LD_LIBS}

pkgb${SHLIB_SUFFIX}: pkgb.o
	${SHLIB_LD} -o pkgb${SHLIB_SUFFIX} pkgb.o ${SHLIB_LD_LIBS}

pkgc${SHLIB_SUFFIX}: pkgc.o
	${SHLIB_LD} -o pkgc${SHLIB_SUFFIX} pkgc.o ${SHLIB_LD_LIBS}

pkgd${SHLIB_SUFFIX}: pkgd.o
	${SHLIB_LD} -o pkgd${SHLIB_SUFFIX} pkgd.o ${SHLIB_LD_LIBS}

pkge${SHLIB_SUFFIX}: pkge.o
	${SHLIB_LD} -o pkge${SHLIB_SUFFIX} pkge.o ${SHLIB_LD_LIBS}

pkgua${SHLIB_SUFFIX}: pkgua.o
	${SHLIB_LD} -o pkgua${SHLIB_SUFFIX} pkgua.o ${SHLIB_LD_LIBS}

pkga${DLTEST_SUFFIX}: pkga.o
	${DLTEST_LD} -o pkga${DLTEST_SUFFIX} pkga.o ${SHLIB_LD_LIBS}

pkgb${DLTEST_SUFFIX}: pkgb.o
	${DLTEST_LD} -o pkgb${DLTEST_SUFFIX} pkgb.o ${SHLIB_LD_LIBS}

pkgc${DLTEST_SUFFIX}: pkgc.o
	${DLTEST_LD} -o pkgc${DLTEST_SUFFIX} pkgc.o ${SHLIB_LD_LIBS}

pkgd${DLTEST_SUFFIX}: pkgd.o
	${DLTEST_LD} -o pkgd${DLTEST_SUFFIX} pkgd.o ${SHLIB_LD_LIBS}

pkge${DLTEST_SUFFIX}: pkge.o
	${DLTEST_LD} -o pkge${DLTEST_SUFFIX} pkge.o ${SHLIB_LD_LIBS}

pkgua${DLTEST_SUFFIX}: pkgua.o
	${DLTEST_LD} -o pkgua${DLTEST_SUFFIX} pkgua.o ${SHLIB_LD_LIBS}

clean:
	rm -f *.o lib.exp ../dltest.marker
	@if test "$(SHLIB_SUFFIX)" != ""; then \
	    echo "rm -f *${SHLIB_SUFFIX}" ; \
	    rm -f *${SHLIB_SUFFIX} ; \
	fi
	@if test "$(DLTEST_SUFFIX)" != ""; then \
	    echo "rm -f *${DLTEST_SUFFIX}" ; \
	    rm -f *${DLTEST_SUFFIX} ; \
	fi

distclean: clean
	rm -f Makefile
