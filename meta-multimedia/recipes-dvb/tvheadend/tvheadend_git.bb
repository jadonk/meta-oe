SUMMARY = "Tvheadend TV streaming server"
HOMEPAGE = "https://www.lonelycoder.com/redmine/projects/tvheadend"

DEPENDS = "libav curl avahi zlib openssl python-native"

LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9eef91148a9b14ec7f9df333daebc746"

SRC_URI = "git://github.com/tvheadend/tvheadend.git \
           file://0001-Move-tvheadend-specific-LD-CFLAGS-into-a-helper-vari.patch \
           file://0001-tvheadend-enable-transcoding-support.patch \
          "
SRCREV = "12e542b7f415f508a2b6f2cffa63dc85f227b9c5"
PV = "3.5"
PR = "r0"

S = "${WORKDIR}/git"

do_configure() {
	./configure --prefix=${prefix} \
	            --libdir=${libdir} \
	            --bindir=${bindir} \
	            --datadir=${datadir} \
	            --arch=${TARGET_ARCH} \
	            --disable-bundle
}

do_install() {
	oe_runmake install DESTDIR=${D}
}

FILES_${PN} += "${datadir}/${BPN}"
