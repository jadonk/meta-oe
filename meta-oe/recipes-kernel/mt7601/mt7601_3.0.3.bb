DESCRIPTION = "Drivers for the MT7601 wifi chipset"

LICENSE = "All-Rights-Reserved"
LIC_FILES_CHKSUM = "file://MODULE/chips/mt7601.c;beginline=1;endline=16;md5=1d76dd484e7b1bc48057b8f4d8279b5d"

inherit module

SRC_URI = "https://googledrive.com/host/0B_JlgOR4VNe0Sjg4ei0ySEY4aUE/DPA_MT7601U_LinuxSTA_3.0.0.3_20130717_LS.tar.bz2"
SRC_URI[md5sum] = "7597450f4374ecaa5798a8f60c956911"
SRC_URI[sha256sum] = "eb834ffe9824963b7a3b9dfaa1b28447cbe26d5a50b57bbb07a0fe4785316e1e"

S = "${WORKDIR}/DPA_MT7601U_LinuxSTA_3.0.0.3_20130717_LS"

EXTRA_OEMAKE = "LINUX_SRC=${STAGING_KERNEL_DIR}" 

do_install() {
    install -d ${D}${sysconfdir}/Wireless/RT2870STA
    install -m 0644 RT2870STA.dat ${D}${sysconfdir}/Wireless/RT2870STA/

    install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
    install -m 0644 MODULE/os/linux/mt7601Usta.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/
    install -m 0644 UTIL/os/linux/mtutil7601Usta.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/
    install -m 0644 NETIF/os/linux/mtnet7601Usta.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/

    install -d ${D}${sysconfdir}/modules-load.d/
    echo mtnet7601Usta > ${D}${sysconfdir}/modules-load.d/mt7601.conf
}

FILES_${PN} += "${sysconfdir}"
