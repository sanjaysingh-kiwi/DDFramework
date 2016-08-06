package com.DDFramework.test;

import org.apache.commons.io.FileUtils;
import org.apache.commons.validator.Var;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.DDFramework.test.DriverScript.*;
import static com.DDFramework.test.GetOSName.OsUtils.isMac;
import static com.DDFramework.test.GetOSName.OsUtils.isWindows;

@SuppressWarnings("ALL")
public class Keywords {

	// public AppiumDriver<MobileElement> driver1;

	public WebDriver driver;
	Date date = new Date();
	SimpleDateFormat dt = new SimpleDateFormat("MMM d, yyyy");
	String downloadLocation;
	String slash = System.getProperty("file.separator");

	private DesiredCapabilities getFirefoxCapability(String downloadLocation) {

		DesiredCapabilities capability = DesiredCapabilities.firefox();

		FirefoxProfile profile = new FirefoxProfile();

		profile.setAcceptUntrustedCertificates(false);
		profile.setAssumeUntrustedCertificateIssuer(true);
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.dir", downloadLocation);
		profile.setPreference("browser.download.downloadDir", downloadLocation);
		profile.setPreference(
				"browser.helperApps.neverAsk.saveToDisk",
				"application/vnd.hzn-3d-crossword;video/3gpp;video/3gpp2;application/vnd.mseq;application/vnd.3m.post-it-notes;application/vnd.3gpp.pic-bw-large;application/vnd.3gpp.pic-bw-small;application/vnd.3gpp.pic-bw-var;application/vnd.3gp2.tcap;application/x-7z-compressed;application/x-abiword;application/x-ace-compressed;application/vnd.americandynamics.acc;application/vnd.acucobol;application/vnd.acucorp;audio/adpcm;application/x-authorware-bin;application/x-athorware-map;application/x-authorware-seg;application/vnd.adobe.air-application-installer-package+zip;application/x-shockwave-flash;application/vnd.adobe.fxp;application/pdf;application/vnd.cups-ppd;application/x-director;applicaion/vnd.adobe.xdp+xml;application/vnd.adobe.xfdf;audio/x-aac;application/vnd.ahead.space;application/vnd.airzip.filesecure.azf;application/vnd.airzip.filesecure.azs;application/vnd.amazon.ebook;application/vnd.amiga.ami;applicatin/andrew-inset;application/vnd.android.package-archive;application/vnd.anser-web-certificate-issue-initiation;application/vnd.anser-web-funds-transfer-initiation;application/vnd.antix.game-component;application/vnd.apple.installe+xml;application/applixware;application/vnd.hhe.lesson-player;application/vnd.aristanetworks.swi;text/x-asm;application/atomcat+xml;application/atomsvc+xml;application/atom+xml;application/pkix-attr-cert;audio/x-aiff;video/x-msvieo;application/vnd.audiograph;image/vnd.dxf;model/vnd.dwf;text/plain-bas;application/x-bcpio;application/octet-stream;image/bmp;application/x-bittorrent;application/vnd.rim.cod;application/vnd.blueice.multipass;application/vnd.bm;application/x-sh;image/prs.btif;application/vnd.businessobjects;application/x-bzip;application/x-bzip2;application/x-csh;text/x-c;application/vnd.chemdraw+xml;text/css;chemical/x-cdx;chemical/x-cml;chemical/x-csml;application/vn.contact.cmsg;application/vnd.claymore;application/vnd.clonk.c4group;image/vnd.dvb.subtitle;application/cdmi-capability;application/cdmi-container;application/cdmi-domain;application/cdmi-object;application/cdmi-queue;applicationvnd.cluetrust.cartomobile-config;application/vnd.cluetrust.cartomobile-config-pkg;image/x-cmu-raster;model/vnd.collada+xml;text/csv;application/mac-compactpro;application/vnd.wap.wmlc;image/cgm;x-conference/x-cooltalk;image/x-cmx;application/vnd.xara;application/vnd.cosmocaller;application/x-cpio;application/vnd.crick.clicker;application/vnd.crick.clicker.keyboard;application/vnd.crick.clicker.palette;application/vnd.crick.clicker.template;application/vn.crick.clicker.wordbank;application/vnd.criticaltools.wbs+xml;application/vnd.rig.cryptonote;chemical/x-cif;chemical/x-cmdf;application/cu-seeme;application/prs.cww;text/vnd.curl;text/vnd.curl.dcurl;text/vnd.curl.mcurl;text/vnd.crl.scurl;application/vnd.curl.car;application/vnd.curl.pcurl;application/vnd.yellowriver-custom-menu;application/dssc+der;application/dssc+xml;application/x-debian-package;audio/vnd.dece.audio;image/vnd.dece.graphic;video/vnd.dec.hd;video/vnd.dece.mobile;video/vnd.uvvu.mp4;video/vnd.dece.pd;video/vnd.dece.sd;video/vnd.dece.video;application/x-dvi;application/vnd.fdsn.seed;application/x-dtbook+xml;application/x-dtbresource+xml;application/vnd.dvb.ait;applcation/vnd.dvb.service;audio/vnd.digital-winds;image/vnd.djvu;application/xml-dtd;application/vnd.dolby.mlp;application/x-doom;application/vnd.dpgraph;audio/vnd.dra;application/vnd.dreamfactory;audio/vnd.dts;audio/vnd.dts.hd;imag/vnd.dwg;application/vnd.dynageo;application/ecmascript;application/vnd.ecowin.chart;image/vnd.fujixerox.edmics-mmr;image/vnd.fujixerox.edmics-rlc;application/exi;application/vnd.proteus.magazine;application/epub+zip;message/rfc82;application/vnd.enliven;application/vnd.is-xpr;image/vnd.xiff;application/vnd.xfdl;application/emma+xml;application/vnd.ezpix-album;application/vnd.ezpix-package;image/vnd.fst;video/vnd.fvt;image/vnd.fastbidsheet;application/vn.denovo.fcselayout-link;video/x-f4v;video/x-flv;image/vnd.fpx;image/vnd.net-fpx;text/vnd.fmi.flexstor;video/x-fli;application/vnd.fluxtime.clip;application/vnd.fdf;text/x-fortran;application/vnd.mif;application/vnd.framemaker;imae/x-freehand;application/vnd.fsc.weblaunch;application/vnd.frogans.fnc;application/vnd.frogans.ltf;application/vnd.fujixerox.ddd;application/vnd.fujixerox.docuworks;application/vnd.fujixerox.docuworks.binder;application/vnd.fujitu.oasys;application/vnd.fujitsu.oasys2;application/vnd.fujitsu.oasys3;application/vnd.fujitsu.oasysgp;application/vnd.fujitsu.oasysprs;application/x-futuresplash;application/vnd.fuzzysheet;image/g3fax;application/vnd.gmx;model/vn.gtw;application/vnd.genomatix.tuxedo;application/vnd.geogebra.file;application/vnd.geogebra.tool;model/vnd.gdl;application/vnd.geometry-explorer;application/vnd.geonext;application/vnd.geoplan;application/vnd.geospace;applicatio/x-font-ghostscript;application/x-font-bdf;application/x-gtar;application/x-texinfo;application/x-gnumeric;application/vnd.google-earth.kml+xml;application/vnd.google-earth.kmz;application/vnd.grafeq;image/gif;text/vnd.graphviz;aplication/vnd.groove-account;application/vnd.groove-help;application/vnd.groove-identity-message;application/vnd.groove-injector;application/vnd.groove-tool-message;application/vnd.groove-tool-template;application/vnd.groove-vcar;video/h261;video/h263;video/h264;application/vnd.hp-hpid;application/vnd.hp-hps;application/x-hdf;audio/vnd.rip;application/vnd.hbci;application/vnd.hp-jlyt;application/vnd.hp-pcl;application/vnd.hp-hpgl;application/vnd.yamaha.h-script;application/vnd.yamaha.hv-dic;application/vnd.yamaha.hv-voice;application/vnd.hydrostatix.sof-data;application/hyperstudio;application/vnd.hal+xml;text/html;application/vnd.ibm.rights-management;application/vnd.ibm.securecontainer;text/calendar;application/vnd.iccprofile;image/x-icon;application/vnd.igloader;image/ief;application/vnd.immervision-ivp;application/vnd.immervision-ivu;application/reginfo+xml;text/vnd.in3d.3dml;text/vnd.in3d.spot;mode/iges;application/vnd.intergeo;application/vnd.cinderella;application/vnd.intercon.formnet;application/vnd.isac.fcs;application/ipfix;application/pkix-cert;application/pkixcmp;application/pkix-crl;application/pkix-pkipath;applicaion/vnd.insors.igm;application/vnd.ipunplugged.rcprofile;application/vnd.irepository.package+xml;text/vnd.sun.j2me.app-descriptor;application/java-archive;application/java-vm;application/x-java-jnlp-file;application/java-serializd-object;text/x-java-source,java;application/javascript;application/json;application/vnd.joost.joda-archive;video/jpm;image/jpeg;video/jpeg;application/vnd.kahootz;application/vnd.chipnuts.karaoke-mmd;application/vnd.kde.karbon;aplication/vnd.kde.kchart;application/vnd.kde.kformula;application/vnd.kde.kivio;application/vnd.kde.kontour;application/vnd.kde.kpresenter;application/vnd.kde.kspread;application/vnd.kde.kword;application/vnd.kenameaapp;applicatin/vnd.kidspiration;application/vnd.kinar;application/vnd.kodak-descriptor;application/vnd.las.las+xml;application/x-latex;application/vnd.llamagraphics.life-balance.desktop;application/vnd.llamagraphics.life-balance.exchange+xml;application/vnd.jam;application/vnd.lotus-1-2-3;application/vnd.lotus-approach;application/vnd.lotus-freelance;application/vnd.lotus-notes;application/vnd.lotus-organizer;application/vnd.lotus-screencam;application/vnd.lotus-wordro;audio/vnd.lucent.voice;audio/x-mpegurl;video/x-m4v;application/mac-binhex40;application/vnd.macports.portpkg;application/vnd.osgeo.mapguide.package;application/marc;application/marcxml+xml;application/mxf;application/vnd.wolfrm.player;application/mathematica;application/mathml+xml;application/mbox;application/vnd.medcalcdata;application/mediaservercontrol+xml;application/vnd.mediastation.cdkey;application/vnd.mfer;application/vnd.mfmp;model/mesh;appliation/mads+xml;application/mets+xml;application/mods+xml;application/metalink4+xml;application/vnd.ms-powerpoint.template.macroenabled.12;application/vnd.ms-word.document.macroenabled.12;application/vnd.ms-word.template.macroenabed.12;application/vnd.mcd;application/vnd.micrografx.flo;application/vnd.micrografx.igx;application/vnd.eszigno3+xml;application/x-msaccess;video/x-ms-asf;application/x-msdownload;application/vnd.ms-artgalry;application/vnd.ms-ca-compressed;application/vnd.ms-ims;application/x-ms-application;application/x-msclip;image/vnd.ms-modi;application/vnd.ms-fontobject;application/vnd.ms-excel;application/vnd.ms-excel.addin.macroenabled.12;application/vnd.ms-excelsheet.binary.macroenabled.12;application/vnd.ms-excel.template.macroenabled.12;application/vnd.ms-excel.sheet.macroenabled.12;application/vnd.ms-htmlhelp;application/x-mscardfile;application/vnd.ms-lrm;application/x-msmediaview;aplication/x-msmoney;application/vnd.openxmlformats-officedocument.presentationml.presentation;application/vnd.openxmlformats-officedocument.presentationml.slide;application/vnd.openxmlformats-officedocument.presentationml.slideshw;application/vnd.openxmlformats-officedocument.presentationml.template;application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;application/vnd.openxmlformats-officedocument.spreadsheetml.template;application/vnd.openxmformats-officedocument.wordprocessingml.document;application/vnd.openxmlformats-officedocument.wordprocessingml.template;application/x-msbinder;application/vnd.ms-officetheme;application/onenote;audio/vnd.ms-playready.media.pya;vdeo/vnd.ms-playready.media.pyv;application/vnd.ms-powerpoint;application/vnd.ms-powerpoint.addin.macroenabled.12;application/vnd.ms-powerpoint.slide.macroenabled.12;application/vnd.ms-powerpoint.presentation.macroenabled.12;appliation/vnd.ms-powerpoint.slideshow.macroenabled.12;application/vnd.ms-project;application/x-mspublisher;application/x-msschedule;application/x-silverlight-app;application/vnd.ms-pki.stl;application/vnd.ms-pki.seccat;application/vn.visio;video/x-ms-wm;audio/x-ms-wma;audio/x-ms-wax;video/x-ms-wmx;application/x-ms-wmd;application/vnd.ms-wpl;application/x-ms-wmz;video/x-ms-wmv;video/x-ms-wvx;application/x-msmetafile;application/x-msterminal;application/msword;application/x-mswrite;application/vnd.ms-works;application/x-ms-xbap;application/vnd.ms-xpsdocument;audio/midi;application/vnd.ibm.minipay;application/vnd.ibm.modcap;application/vnd.jcp.javame.midlet-rms;application/vnd.tmobile-ivetv;application/x-mobipocket-ebook;application/vnd.mobius.mbk;application/vnd.mobius.dis;application/vnd.mobius.plc;application/vnd.mobius.mqy;application/vnd.mobius.msl;application/vnd.mobius.txf;application/vnd.mobius.daf;tex/vnd.fly;application/vnd.mophun.certificate;application/vnd.mophun.application;video/mj2;audio/mpeg;video/vnd.mpegurl;video/mpeg;application/mp21;audio/mp4;video/mp4;application/mp4;application/vnd.apple.mpegurl;application/vnd.msician;application/vnd.muvee.style;application/xv+xml;application/vnd.nokia.n-gage.data;application/vnd.nokia.n-gage.symbian.install;application/x-dtbncx+xml;application/x-netcdf;application/vnd.neurolanguage.nlu;application/vnd.na;application/vnd.noblenet-directory;application/vnd.noblenet-sealer;application/vnd.noblenet-web;application/vnd.nokia.radio-preset;application/vnd.nokia.radio-presets;text/n3;application/vnd.novadigm.edm;application/vnd.novadim.edx;application/vnd.novadigm.ext;application/vnd.flographit;audio/vnd.nuera.ecelp4800;audio/vnd.nuera.ecelp7470;audio/vnd.nuera.ecelp9600;application/oda;application/ogg;audio/ogg;video/ogg;application/vnd.oma.dd2+xml;applicatin/vnd.oasis.opendocument.text-web;application/oebps-package+xml;application/vnd.intu.qbo;application/vnd.openofficeorg.extension;application/vnd.yamaha.openscoreformat;audio/webm;video/webm;application/vnd.oasis.opendocument.char;application/vnd.oasis.opendocument.chart-template;application/vnd.oasis.opendocument.database;application/vnd.oasis.opendocument.formula;application/vnd.oasis.opendocument.formula-template;application/vnd.oasis.opendocument.grapics;application/vnd.oasis.opendocument.graphics-template;application/vnd.oasis.opendocument.image;application/vnd.oasis.opendocument.image-template;application/vnd.oasis.opendocument.presentation;application/vnd.oasis.opendocumen.presentation-template;application/vnd.oasis.opendocument.spreadsheet;application/vnd.oasis.opendocument.spreadsheet-template;application/vnd.oasis.opendocument.text;application/vnd.oasis.opendocument.text-master;application/vnd.asis.opendocument.text-template;image/ktx;application/vnd.sun.xml.calc;application/vnd.sun.xml.calc.template;application/vnd.sun.xml.draw;application/vnd.sun.xml.draw.template;application/vnd.sun.xml.impress;application/vnd.sun.xl.impress.template;application/vnd.sun.xml.math;application/vnd.sun.xml.writer;application/vnd.sun.xml.writer.global;application/vnd.sun.xml.writer.template;application/x-font-otf;application/vnd.yamaha.openscoreformat.osfpvg+xml;application/vnd.osgi.dp;application/vnd.palm;text/x-pascal;application/vnd.pawaafile;application/vnd.hp-pclxl;application/vnd.picsel;image/x-pcx;image/vnd.adobe.photoshop;application/pics-rules;image/x-pict;application/x-chat;aplication/pkcs10;application/x-pkcs12;application/pkcs7-mime;application/pkcs7-signature;application/x-pkcs7-certreqresp;application/x-pkcs7-certificates;application/pkcs8;application/vnd.pocketlearn;image/x-portable-anymap;image/-portable-bitmap;application/x-font-pcf;application/font-tdpfr;application/x-chess-pgn;image/x-portable-graymap;image/png;image/x-portable-pixmap;application/pskc+xml;application/vnd.ctc-posml;application/postscript;application/xfont-type1;application/vnd.powerbuilder6;application/pgp-encrypted;application/pgp-signature;application/vnd.previewsystems.box;application/vnd.pvi.ptid1;application/pls+xml;application/vnd.pg.format;application/vnd.pg.osasli;tex/prs.lines.tag;application/x-font-linux-psf;application/vnd.publishare-delta-tree;application/vnd.pmi.widget;application/vnd.quark.quarkxpress;application/vnd.epson.esf;application/vnd.epson.msf;application/vnd.epson.ssf;applicaton/vnd.epson.quickanime;application/vnd.intu.qfx;video/quicktime;application/x-rar-compressed;audio/x-pn-realaudio;audio/x-pn-realaudio-plugin;application/rsd+xml;application/vnd.rn-realmedia;application/vnd.realvnc.bed;applicatin/vnd.recordare.musicxml;application/vnd.recordare.musicxml+xml;application/relax-ng-compact-syntax;application/vnd.data-vision.rdz;application/rdf+xml;application/vnd.cloanto.rp9;application/vnd.jisp;application/rtf;text/richtex;application/vnd.route66.link66+xml;application/rss+xml;application/shf+xml;application/vnd.sailingtracker.track;image/svg+xml;application/vnd.sus-calendar;application/sru+xml;application/set-payment-initiation;application/set-reistration-initiation;application/vnd.sema;application/vnd.semd;application/vnd.semf;application/vnd.seemail;application/x-font-snf;application/scvp-vp-request;application/scvp-vp-response;application/scvp-cv-request;application/svp-cv-response;application/sdp;text/x-setext;video/x-sgi-movie;application/vnd.shana.informed.formdata;application/vnd.shana.informed.formtemplate;application/vnd.shana.informed.interchange;application/vnd.shana.informed.package;application/thraud+xml;application/x-shar;image/x-rgb;application/vnd.epson.salt;application/vnd.accpac.simply.aso;application/vnd.accpac.simply.imp;application/vnd.simtech-mindmapper;application/vnd.commonspace;application/vnd.ymaha.smaf-audio;application/vnd.smaf;application/vnd.yamaha.smaf-phrase;application/vnd.smart.teacher;application/vnd.svd;application/sparql-query;application/sparql-results+xml;application/srgs;application/srgs+xml;application/sml+xml;application/vnd.koan;text/sgml;application/vnd.stardivision.calc;application/vnd.stardivision.draw;application/vnd.stardivision.impress;application/vnd.stardivision.math;application/vnd.stardivision.writer;application/vnd.tardivision.writer-global;application/vnd.stepmania.stepchart;application/x-stuffit;application/x-stuffitx;application/vnd.solent.sdkm+xml;application/vnd.olpc-sugar;audio/basic;application/vnd.wqd;application/vnd.symbian.install;application/smil+xml;application/vnd.syncml+xml;application/vnd.syncml.dm+wbxml;application/vnd.syncml.dm+xml;application/x-sv4cpio;application/x-sv4crc;application/sbml+xml;text/tab-separated-values;image/tiff;application/vnd.to.intent-module-archive;application/x-tar;application/x-tcl;application/x-tex;application/x-tex-tfm;application/tei+xml;text/plain;application/vnd.spotfire.dxp;application/vnd.spotfire.sfs;application/timestamped-data;applicationvnd.trid.tpt;application/vnd.triscape.mxs;text/troff;application/vnd.trueapp;application/x-font-ttf;text/turtle;application/vnd.umajin;application/vnd.uoml+xml;application/vnd.unity;application/vnd.ufdl;text/uri-list;application/nd.uiq.theme;application/x-ustar;text/x-uuencode;text/x-vcalendar;text/x-vcard;application/x-cdlink;application/vnd.vsf;model/vrml;application/vnd.vcx;model/vnd.mts;model/vnd.vtu;application/vnd.visionary;video/vnd.vivo;applicatin/ccxml+xml,;application/voicexml+xml;application/x-wais-source;application/vnd.wap.wbxml;image/vnd.wap.wbmp;audio/x-wav;application/davmount+xml;application/x-font-woff;application/wspolicy+xml;image/webp;application/vnd.webturb;application/widget;application/winhlp;text/vnd.wap.wml;text/vnd.wap.wmlscript;application/vnd.wap.wmlscriptc;application/vnd.wordperfect;application/vnd.wt.stf;application/wsdl+xml;image/x-xbitmap;image/x-xpixmap;image/x-xwindowump;application/x-x509-ca-cert;application/x-xfig;application/xhtml+xml;application/xml;application/xcap-diff+xml;application/xenc+xml;application/patch-ops-error+xml;application/resource-lists+xml;application/rls-services+xml;aplication/resource-lists-diff+xml;application/xslt+xml;application/xop+xml;application/x-xpinstall;application/xspf+xml;application/vnd.mozilla.xul+xml;chemical/x-xyz;text/yaml;application/yang;application/yin+xml;application/vnd.ul;application/zip;application/vnd.handheld-entertainment+xml;application/vnd.zzazz.deck+xml");
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.download.manager.focusWhenStarting",
				false);
		profile.setPreference("browser.download.useDownloadDir", true);
		profile.setPreference("browser.download.manager.closeWhenDone", true);
		profile.setPreference("browser.download.manager.showAlertOnComplete",
				false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference(
				"services.sync.prefs.sync.browser.download.manager.showWhenStarting",
				false);
		profile.setPreference("pdfjs.disabled", true);

		capability.setCapability(FirefoxDriver.PROFILE, profile);

		return capability;
	}

	private DesiredCapabilities getChromeCapability(String downloadLocation) {

		DesiredCapabilities capability = DesiredCapabilities.chrome();

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadLocation);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(ChromeOptions.CAPABILITY, options);

		return capability;
	}

	public String openBrowser(String object, String data) {

		// Chrome Driver Path

		DesiredCapabilities capability = null;
		downloadLocation = System.getProperty("user.dir") + slash + "Downloads";

		System.setProperty("webdriver.chrome.driver",
				"ChromeDriver/chromedriver.exe");

		// Internet Explorer Path
		if (isWindows()) {
			File file = new File("IEDriver/IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		}

		APP_LOGS.debug("Opening browser");
		if (data.equals("Mozilla")) {
			capability = getFirefoxCapability(downloadLocation);
			driver = new FirefoxDriver(capability);
		} else if (data.equals("IE"))
			driver = new InternetExplorerDriver();
		else if (data.equals("Chrome")) {
			capability = getChromeCapability(downloadLocation);
			driver = new ChromeDriver(capability);
		}

		long implicitWaitTime = Long.parseLong(CONFIG
				.getProperty("implicitwait"));
		driver.manage().timeouts()
				.implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		return Constants.KEYWORD_PASS;

	}

	public String navigate(String object, String data) {
		APP_LOGS.debug("Navigating to URL");
		try {
			Thread.sleep(10000l);
			driver.manage().window().maximize();
			driver.navigate().to(data);

		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " -- Not able to navigate";
		}
		return Constants.KEYWORD_PASS;
	}


	public String clickLink(String object, String data) {
		APP_LOGS.debug("Clicking on link ");
		try {
			String value;
				value = OR.getProperty(object);
			driver.findElement(By.xpath(value)).click();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " -- Not able to click on link"
					+ e.getMessage();
		}
		return Constants.KEYWORD_PASS;
	}


	public String mouseHoverAndClick(String object, String data) {
		APP_LOGS.debug("Mouse hover and then click");
		try {
			String value;
				value = OR.getProperty(object);
			WebElement element = driver.findElement(By.xpath(value));
			Actions builder = new Actions(driver);
			// builder.moveToElement(element).perform();
			// Thread.sleep(5000L);
			builder.moveToElement(element).click(element).perform();

		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL
					+ " -- Not able to download the image" + e.getMessage();
		}
		return Constants.KEYWORD_PASS;
	}


	public String clickLinkCss(String object, String data) {
		APP_LOGS.debug("Clicking on link ");
		try {
			driver.findElement(By.cssSelector(OR.getProperty(object))).click();
		} catch (Exception e) {
			e.printStackTrace();
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " -- Not able to click on link"
					+ e.getMessage();
		}

		return Constants.KEYWORD_PASS;
	}

	public String clickLink_linkText(String object, String data) {
		APP_LOGS.debug("Clicking on link ");
		driver.findElement(By.linkText(OR.getProperty(object))).click();

		return Constants.KEYWORD_PASS;
	}

	public String clickLink_name(String object, String data) {
		APP_LOGS.debug("Clicking on link ");
		driver.findElement(By.name(OR.getProperty(object))).click();

		return Constants.KEYWORD_PASS;
	}

	public String verifyLinkText(String object, String data) {
		APP_LOGS.debug("Verifying link Text");
		try {
			String actual = driver
					.findElement(By.xpath(OR.getProperty(object))).getText();
			String expected = data;

			if (actual.equals(expected))
				return Constants.KEYWORD_PASS;
			else
				return Constants.KEYWORD_FAIL + " -- Link text not verified";

		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " -- Link text not verified"
					+ e.getMessage();

		}

	}

	public String clickButton(String object, String data) {
		APP_LOGS.debug("Clicking on Button");
		try {
			driver.findElement(By.xpath(OR.getProperty(object))).click();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " -- Not able to click on Button"
					+ e.getMessage();
		}

		return Constants.KEYWORD_PASS;
	}

	public String clickButtonCss(String object, String data) {
		APP_LOGS.debug("Clicking on Button");
		try {
			driver.findElement(By.cssSelector(OR.getProperty(object))).click();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " -- Not able to click on Button"
					+ e.getMessage();
		}
		return Constants.KEYWORD_PASS;
	}

	public String verifyButtonText(String object, String data) {
		APP_LOGS.debug("Verifying the button text");
		try {
			String actual = driver
					.findElement(By.xpath(OR.getProperty(object))).getText();
			String expected = data;

			if (actual.equals(expected))
				return Constants.KEYWORD_PASS;
			else
				return Constants.KEYWORD_FAIL + " -- Button text not verified "
						+ actual + " -- " + expected;
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " Object not found "
					+ e.getMessage();
		}

	}

	public String selectList(String object, String data) {
		APP_LOGS.debug("Selecting from list");
		try {
			if (!data.equals(Constants.RANDOM_VALUE)) {
				driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(
						data);
			} else {
				// logic to find a random value in list
				WebElement droplist = driver.findElement(By.xpath(OR
						.getProperty(object)));
				List<WebElement> droplist_cotents = droplist.findElements(By
						.tagName("EXPO"));
				Random num = new Random();
				int index = num.nextInt(droplist_cotents.size());
				String selectedVal = droplist_cotents.get(index).getText();

				driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(
						selectedVal);
			}
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	public String verifyAllListElements(String object, String data) {
		APP_LOGS.debug("Verifying the selection of the list");
		try {
			WebElement droplist = driver.findElement(By.xpath(OR
					.getProperty(object)));
			List<WebElement> droplist_cotents = droplist.findElements(By
					.tagName("option"));

			// extract the expected values from OR. properties
			String temp = data;
			String allElements[] = temp.split(",");
			// check if size of array == size if list
			if (allElements.length != droplist_cotents.size())
				return Constants.KEYWORD_FAIL + "- size of lists do not match";

			for (int i = 0; i < droplist_cotents.size(); i++) {
				if (!allElements[i].equals(droplist_cotents.get(i).getText())) {
					return Constants.KEYWORD_FAIL + "- Element not found - "
							+ allElements[i];
				}
			}
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	public String verifyListSelection(String object, String data) {
		APP_LOGS.debug("Verifying all the list elements");
		try {
			String expectedVal = data;
			// System.out.println(driver.findElement(By.xpath(OR.getProperty(object))).getText());
			WebElement droplist = driver.findElement(By.xpath(OR
					.getProperty(object)));
			List<WebElement> droplist_cotents = droplist.findElements(By
					.tagName("option"));
			String actualVal = null;
			for (int i = 0; i < droplist_cotents.size(); i++) {
				String selected_status = droplist_cotents.get(i).getAttribute(
						"selected");
				if (selected_status != null)
					actualVal = droplist_cotents.get(i).getText();
			}

			if (!actualVal.equals(expectedVal))
				return Constants.KEYWORD_FAIL + "Value not in list - "
						+ expectedVal;

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not find list. "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	public String selectRadio(String object, String data) {
		APP_LOGS.debug("Selecting a radio button");
		try {
			String temp[] = object.split(Constants.DATA_SPLIT);
			driver.findElement(
					By.xpath(OR.getProperty(temp[0]) + data
							+ OR.getProperty(temp[1]))).click();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + "- Not able to find radio button";

		}

		return Constants.KEYWORD_PASS;

	}

	public String verifyRadioSelected(String object, String data) {
		APP_LOGS.debug("Verify Radio Selected");
		try {
			String temp[] = object.split(Constants.DATA_SPLIT);
			String checked = driver.findElement(
					By.xpath(OR.getProperty(temp[0]) + data
							+ OR.getProperty(temp[1]))).getAttribute("checked");
			if (checked == null)
				return Constants.KEYWORD_FAIL + "- Radio not selected";

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + "- Not able to find radio button";

		}

		return Constants.KEYWORD_PASS;

	}

	public String checkCheckBox(String object, String data) {
		APP_LOGS.debug("Checking checkbox");
		try {
			// true or null
			String checked = driver.findElement(
					By.xpath(OR.getProperty(object))).getAttribute("checked");
			if (checked == null)// checkbox is unchecked
				driver.findElement(By.xpath(OR.getProperty(object))).click();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " - Could not find checkbo";
		}
		return Constants.KEYWORD_PASS;

	}

	public String unCheckCheckBox(String object, String data) {
		APP_LOGS.debug("Unchecking checkBox");
		try {
			String checked = driver.findElement(
					By.xpath(OR.getProperty(object))).getAttribute("checked");
			if (checked != null)
				driver.findElement(By.xpath(OR.getProperty(object))).click();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " - Could not find checkbox";
		}
		return Constants.KEYWORD_PASS;

	}

	public String verifyCheckBoxSelected(String object, String data) {
		APP_LOGS.debug("Verifying checkbox selected");
		try {
			String checked = driver.findElement(
					By.xpath(OR.getProperty(object))).getAttribute("checked");
			if (checked != null)
				return Constants.KEYWORD_PASS;
			else
				return Constants.KEYWORD_FAIL + " - Not selected";

		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " - Could not find checkbox";

		}

	}

	public String verifyText(String object, String data) {
		APP_LOGS.debug("Verifying the text");
		try {
			String actual = driver
					.findElement(By.xpath(OR.getProperty(object))).getText();
			String expected = data;

			if (actual.equals(expected))
				return Constants.KEYWORD_PASS;
			else
				return Constants.KEYWORD_FAIL + " -- text not verified "
						+ actual + " -- " + expected;
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " Object not found "
					+ e.getMessage();
		}

	}


	public String writeInInput(String object, String data) {
		APP_LOGS.debug("Writing in text box");

		try {
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " Unable to write "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;
	}

	public String writeInInputID(String object, String data) {
		APP_LOGS.debug("Writing in text box");

		try {
			driver.findElement(By.id(OR.getProperty(object))).sendKeys(data);
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " Unable to write "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	public void waitForSpinner() {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//div[@class='spinner-container short ng-hide']")));
	}

	public String setCampaignStatus(String object, String data) {
		APP_LOGS.debug("Setting Campaign Status");
		try {
			waitForSpinner();
			WebElement dropdown = driver.findElement(By.xpath(OR
					.getProperty(object)));
			Select select = new Select(dropdown);
			select.selectByVisibleText(data);
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " Unable to write "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;
	}

	public String writeInInputCss(String object, String data) {
		APP_LOGS.debug("Writing in text box");

		try {
			driver.findElement(By.cssSelector(OR.getProperty(object)))
					.sendKeys(data);
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " Unable to write "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	public String verifyTextinInput(String object, String data) {
		APP_LOGS.debug("Verifying the text in input box");
		try {
			String actual = driver
					.findElement(By.xpath(OR.getProperty(object)))
					.getAttribute("value");
			String expected = data;

			if (actual.equals(expected)) {
				return Constants.KEYWORD_PASS;
			} else {
				return Constants.KEYWORD_FAIL + " Not matching ";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " Unable to find input box "
					+ e.getMessage();

		}
	}


	public String verifyTitle(String object, String data) {
		APP_LOGS.debug("Verifying title");
		try {
			String actualTitle = driver.getTitle();
			String expectedTitle = data;
			if (actualTitle.equals(expectedTitle))
				return Constants.KEYWORD_PASS;
			else
				return Constants.KEYWORD_FAIL + " -- Title not verified "
						+ expectedTitle + " -- " + actualTitle;
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " Error in retrieving title";
		}
	}

	public String exist(String object, String data) {
		APP_LOGS.debug("Checking existance of element");
		try {
			driver.findElement(By.xpath(OR.getProperty(object)));
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " Object doest not exist";
		}

		return Constants.KEYWORD_PASS;
	}

	public String click(String object, String data) {
		APP_LOGS.debug("Clicking on any element");
		try {
			driver.findElement(By.xpath(OR.getProperty(object))).click();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " Not able to click";
		}
		return Constants.KEYWORD_PASS;
	}

	public String clickCss(String object, String data) {
		APP_LOGS.debug("Clicking on any element");
		try {
			driver.findElement(By.cssSelector(OR.getProperty(object))).click();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " Not able to click";
		}
		return Constants.KEYWORD_PASS;
	}

	public String synchronize(String object, String data) {
		APP_LOGS.debug("Waiting for page to load");
		((JavascriptExecutor) driver)
				.executeScript("function pageloadingtime()" + "{"
						+ "return 'Page has completely loaded'" + "}"
						+ "return (window.onload=pageloadingtime());");

		return Constants.KEYWORD_PASS;
	}

	public String waitForElementVisibility(String object, String data) {
		APP_LOGS.debug("Waiting for an element to be visible");
		int start = 0;
		int time = (int) Double.parseDouble(data);
		try {
			while (time == start) {
				if (driver.findElements(By.xpath(OR.getProperty(object)))
						.size() == 0) {
					Thread.sleep(1000L);
					start++;
				} else {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL
					+ "Unable to close browser. Check if its open"
					+ e.getMessage();
		}
		return Constants.KEYWORD_PASS;
	}

	public String closeBrowser(String object, String data) {
		APP_LOGS.debug("Closing the browser");
		try {
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL
					+ "Unable to close browser. Check if its open"
					+ e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

	public String deleteAllCookies(String object, String data) {
		APP_LOGS.debug("Deleting all the Browser cookies");
		try {
			driver.manage().deleteAllCookies();
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL
					+ "Unable delete all the cookies from Browser"
					+ e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

	public String quitBrowser(String object, String data) {
		APP_LOGS.debug("Closing the browser");
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL
					+ "Unable to close browser. Check if its open"
					+ e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

	public String pause(String object, String data)
			throws NumberFormatException, InterruptedException {
		long time = (long) Double.parseDouble(object);
		Thread.sleep(time * 1000L);
		return Constants.KEYWORD_PASS;
	}


	public String enter(String object, String data) {
		APP_LOGS.debug("Pressing Enter");
		try {
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(
					Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL
					+ "Unable to go back, Check if its open" + e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

	public String tab(String object, String data) {
		APP_LOGS.debug("Going back one page");
		try {
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(
					Keys.TAB);
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL
					+ "Unable to go back, Check if its open" + e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

	public String enterCss(String object, String data) {
		APP_LOGS.debug("Going back one page");
		try {
			driver.findElement(By.cssSelector(OR.getProperty(object)))
					.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL
					+ "Unable to go back, Check if its open" + e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

	public String windowHandler(String object, String data) {
		APP_LOGS.debug("Handling multiple windows");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		try {
			String mainWindowHandle = driver.getWindowHandle();
			driver.findElement(By.xpath(OR.getProperty(object))).click();
			Set<String> window = driver.getWindowHandles();
			Iterator<String> iterator = window.iterator();

			while (iterator.hasNext()) {
				String popupHandle = iterator.next().toString();
				if (!popupHandle.contains(mainWindowHandle)) {
					driver.switchTo().window(popupHandle);
				}
			}

			// Back to main window
			// driver.switchTo().window(mainWindowHandle);

		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL
					+ "Unable to handle windows, See log4j report for more info"
					+ e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

	public String click_JS(String object, String data) {
		APP_LOGS.debug("Clicking on any element using JavaScript");
		try {
			((JavascriptExecutor) driver)
					.executeScript("document.getElementById('" + object
							+ "').click()");
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL
					+ "Unable to click, Check if its open" + e.getMessage();
		}
		return Constants.KEYWORD_PASS;
	}

	public String writeInInput_JS(String object, String data) {
		APP_LOGS.debug("Writing in text box using JavaScript");
		try {
			((JavascriptExecutor) driver)
					.executeScript("document.getElementById('" + object
							+ "').value='" + data + "'");
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL
					+ "Unable to write, Check if its open" + e.getMessage();
		}
		return Constants.KEYWORD_PASS;
	}

	// << Go back one page
	public String goBack(String object, String data) {
		APP_LOGS.debug("Going back one page");
		try {
			driver.navigate().back();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL
					+ "Unable to go back, Check if its open" + e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

	// >> Go to forward one page
	public String goForward(String object, String data) {
		APP_LOGS.debug("Going back one page");
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL
					+ "Unable to go back, Check if its open" + e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

	// Verify list of items after clicking on drop-down list like Newborn, Shoes
	// etc.
	public String verifyAllItems(String object, String data) {
		APP_LOGS.debug("Verifying link Text");
		try {
			for (int i = 0; i <= 150; i++) {
				List<WebElement> gridBoxes = driver.findElements(By
						.className("events-div"));
				System.out.println("Number of boxes " + gridBoxes.size());
				// Pick random link box
				Random gridnum = new Random();
				int grids = gridnum.nextInt(gridBoxes.size());
				WebElement grid = gridBoxes.get(grids);
				// WebElement box = link_boxes.get(0);
				List<WebElement> ItemBoxes = grid.findElements(By
						.className("product-image"));
				System.out.println("Total links are -- " + ItemBoxes.size());
				// Pick random item
				Random itemnum = new Random();
				int items = itemnum.nextInt(ItemBoxes.size());
				WebElement item = ItemBoxes.get(items);
				item.click();
				Thread.sleep(4000L);
				System.out.println(driver.getTitle());
				driver.navigate().back();

			}
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " -- Link text not verified"
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;
	}

	// Credit Card functionality at the CheckOut
	public String selectExpMonth(String object, String data) {
		APP_LOGS.debug("Selecting Expiration Month");
		try {
			WebElement states = driver.findElement(By.xpath(OR
					.getProperty(object)));
			List<WebElement> state = states.findElements(By.tagName("option"));
			Random num = new Random();
			int index = num.nextInt(state.size());
			state.get(index).click();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	// Credit Card functionality at the CheckOut
	public String selectExpYear(String object, String data) {
		APP_LOGS.debug("Selecting Expiration Year");
		try {
			WebElement states = driver.findElement(By.xpath(OR
					.getProperty(object)));
			List<WebElement> state = states.findElements(By.tagName("option"));
			Random num = new Random();
			int index = num.nextInt(state.size());
			state.get(index).click();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	// Credit Card functionality at the CheckOut
	public String selectAmex(String object, String data) {
		APP_LOGS.debug("Selecting American Express Card");
		try {
			WebElement size = driver.findElement(By.xpath(OR
					.getProperty(object)));
			List<WebElement> selectSize = size.findElements(By
					.tagName("option"));
			selectSize.get(0).click();

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	// Credit Card functionality at the CheckOut
	public String selectVisa(String object, String data) {
		APP_LOGS.debug("Selecting Visa Credit Card");
		try {
			WebElement size = driver.findElement(By.xpath(OR
					.getProperty(object)));
			List<WebElement> selectSize = size.findElements(By
					.tagName("option"));
			selectSize.get(1).click();

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	// Credit Card functionality at the CheckOut
	public String selectMasterCard(String object, String data) {
		APP_LOGS.debug("Selecting MasterCard");
		try {
			WebElement size = driver.findElement(By.xpath(OR
					.getProperty(object)));
			List<WebElement> selectSize = size.findElements(By
					.tagName("option"));
			selectSize.get(2).click();

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	public String selectRandomState(String object, String data) {
		APP_LOGS.debug("Selecting Random States");
		try {
			WebElement states = driver.findElement(By.xpath(OR
					.getProperty(object)));
			List<WebElement> state = states.findElements(By.tagName("option"));
			Random num = new Random();
			int index = num.nextInt(state.size());
			state.get(index++).click();
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	public String selectEvent(String object, String data) {
		APP_LOGS.debug("Selecting Random event");
		try {
			WebElement eventList = driver.findElement(By
					.xpath("//*[@id='events-live']/ul"));
			List<WebElement> events = eventList.findElements(By
					.xpath("//*[@class='event-link']"));

			int time = Integer.parseInt(object);

			if (events.size() == 0) {
				APP_LOGS.debug("There's no events on the page");

			} else {
				events.get(time).click();
			}

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	public String selectRandomEvent(String object, String data) {
		APP_LOGS.debug("Selecting Random event");
		try {
			List<WebElement> events = driver.findElements(By
					.xpath("//*[@id='events-live']/ul/li[not(@style)]/a"));
			Random num = new Random();
			int index = num.nextInt(events.size());
			WebElement menu = events.get(index);
			Actions builder = new Actions(driver);
			builder.moveToElement(menu).build().perform();
			menu.click();

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	public String selectProduct(String object, String data) {
		APP_LOGS.debug("Selecting Random Product");

		int time = Integer.parseInt(object);

		try {
			List<WebElement> items = driver.findElements(By
					.xpath("//*[@class='product-image']"));
			if (items.size() == 0) {
				APP_LOGS.debug("There's no product on the page");
				driver.navigate().back();
				selectRandomEvent(object, data);
				selectRandomProduct(object, data);

			} else {
				items.get(time).click();
			}
		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	public String selectRandomProduct(String object, String data) {
		APP_LOGS.debug("Selecting Random Product");
		try {
			List<WebElement> items = driver.findElements(By
					.xpath("//*[@class='thumbnail'][not(@status_sold_out)]/a"));
			Random num = new Random();
			int index = num.nextInt(items.size());
			items.get(index).click();

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	public String selectRandomColor(String object, String data) {
		APP_LOGS.debug("Selecting Random Color");
		try {
			WebElement color = driver.findElement(By
					.xpath("//*[@id='attribute85']"));
			List<WebElement> selectColor = color.findElements(By
					.tagName("option"));
			selectColor.get(1).click();

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	public String selectRandomSize(String object, String data) {
		APP_LOGS.debug("Selecting Random Size");
		try {
			WebElement size = driver.findElement(By
					.xpath("//*[@id='attribute169']"));
			List<WebElement> selectSize = size.findElements(By
					.tagName("option"));
			selectSize.get(1).click();

		} catch (Exception e) {
			return Constants.KEYWORD_FAIL + " - Could not select from list. "
					+ e.getMessage();

		}

		return Constants.KEYWORD_PASS;
	}

	public String chrodKeys(String object, String data) {
		APP_LOGS.debug("Selecting in text box");

		try {
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(
					Keys.chord(data));
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " Unable to select "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	public String chrodKeysCss(String object, String data) {
		APP_LOGS.debug("Selecting in text box");

		try {
			driver.findElement(By.cssSelector(OR.getProperty(object)))
					.sendKeys(Keys.chord(data));
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " Unable to select "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	public String clearInputText(String object, String data) {
		APP_LOGS.debug("Clearing input text box");

		try {
			driver.findElement(By.xpath(OR.getProperty(object))).clear();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " Unable to clear input text "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	public String clearInputText_css(String object, String data) {
		APP_LOGS.debug("Clearing input text box");

		try {
			driver.findElement(By.cssSelector(OR.getProperty(object))).clear();
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + " Unable to clear input text "
					+ e.getMessage();

		}
		return Constants.KEYWORD_PASS;

	}

	public String mouseHover(String object, String data) {
		APP_LOGS.debug("Mouse Hovering to the element");
		try {

			Thread.sleep(3000L);
			WebElement menu;
				menu = driver.findElement(By.xpath(OR.getProperty(object)));
			Actions builder = new Actions(driver);
			builder.moveToElement(menu).build().perform();

		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + "Unable to mouse hover"
					+ e.getMessage();
		}
		return Constants.KEYWORD_PASS;
	}

	public String mouseHoverCss(String object, String data) {
		APP_LOGS.debug("Mouse Hovering to the element");
		try {

			Thread.sleep(3000L);
			WebElement menu = driver.findElement(By.cssSelector(OR
					.getProperty(object)));
			Actions builder = new Actions(driver);
			builder.moveToElement(menu).build().perform();

		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + "Unable to mouse hover"
					+ e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

	public String doubleClick(String object, String data) {
		APP_LOGS.debug("Mouse Hovering to the element");
		try {

			Thread.sleep(3000L);
			WebElement menu = driver.findElement(By.xpath(OR
					.getProperty(object)));
			Actions builder = new Actions(driver);
			builder.doubleClick(menu).build().perform();

		} catch (Exception e) {
			e.printStackTrace();
			return Constants.KEYWORD_FAIL + "Unable to mouse hover"
					+ e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}

	public String validateLogin(String object, String data) {
		// object of the current test XLS
		// name of my current test case
		System.out.println("xxxxxxxxxxxxxxxxxxxxx");
		String data_flag = currentTestSuiteXLS.getCellData(currentTestCaseName,
				"Data_correctness", currentTestDataSetID);

		try {

			String expected = driver.findElement(
					By.xpath(OR.getProperty("myAccount_link"))).getText();
			String unexpected = driver.findElement(
					By.cssSelector(OR.getProperty("login_signIn_button_css")))
					.getText();

			if (expected.equals(null))
				if (!data_flag.equals(Constants.POSITIVE_DATA))
					return Constants.KEYWORD_PASS;
				else
					return Constants.KEYWORD_FAIL;

		} catch (Exception e) {

		}

		// check for page title
		if (data_flag.equals(Constants.POSITIVE_DATA))
			return Constants.KEYWORD_PASS;
		else
			return Constants.KEYWORD_FAIL;
	}

	public void captureScreenshot(String filename,
			String keyword_execution_result) throws IOException {
		// take screen shots
		if (CONFIG.getProperty("screenshot_everystep").equals("Y")) {
			// capturescreen

			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")
					+ "//screenshots//" + filename + ".jpg"));

		} else if (keyword_execution_result.startsWith(Constants.KEYWORD_FAIL)
				&& CONFIG.getProperty("screenshot_error").equals("Y")) {
			// capture screenshot
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")
					+ "//screenshots//" + filename + ".jpg"));
		}
	}

}
