DESCRIPTION = "AVRDUDE is software for programming Atmel AVR Microcontrollers."
HOMEPAGE = "http://www.nongnu.org/avrdude/"
SECTION = "console"

PV = "5.11+6.0rc1"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=4f51bb496ef8872ccff73f440f2464a8"

DEPENDS = "libusb1 libftdi ncurses"

inherit autotools

SRC_URI = "http://savannah.nongnu.org/download/avrdude/avrdude-6.0rc1.tar.gz"
SRC_URI[md5sum] = "569787a433e43027eb3f847dccb48ea0"
SRC_URI[sha256sum] = "4d85904315805f51cce6436eb91a084bb6030dccf9b503aff719229bf23a2b6c"

S = "${WORKDIR}/avrdude-6.0rc1/"

