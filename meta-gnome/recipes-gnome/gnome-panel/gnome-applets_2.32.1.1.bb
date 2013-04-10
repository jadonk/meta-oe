DESCRIPTION = "Misc applets for Gnome panel"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=3bf50002aefd002f49e7bb854063f7e7"

inherit distutils-common-base gnome

SRC_URI += " \
            file://0001-configure-remove-libpanelapplet2-dependency.patch \
            file://0002-disable-help-build.patch \
            file://0003-remove-null-applet-it-doesn-t-build.patch \
"

SRC_URI[archive.md5sum] = "031c207a18707263828b4a4fd784bbe4"
SRC_URI[archive.sha256sum] = "2b92fe4b3062dfbe264f45472b4db3a27d1e69e13260d37da9fb36b2cbd40327"

DEPENDS = "gtk+ glib-2.0 gconf gnome-desktop libxklavier libnotify dbus-glib gnome-icon-theme libxml2"

# NM is only used to ask the weather plugin to update on ifup
EXTRA_OECONF = "--disable-gtk-doc --disable-scrollkeeper --enable-networkmanager=no"

FILES_${PN} += " \
                ${sysconfdir} \
                ${datadir} \
                ${libexecdir} \
               "

