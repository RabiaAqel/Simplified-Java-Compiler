rabeaaqel


==============================================================================
          _                   _________  __  ______   ______   _______ 
  ___    (_)___ __  _____ _  / ___/ __ \/  |/  / _ \ /  _/ /  / __/ _ \
 (_-<   / // _ `/ |/ / _ `/ / /__/ /_/ / /|_/ / ___/_/ // /__/ _// , _/
/___/__/ / \_,_/|___/\_,_/  \___/\____/_/  /_/_/   /___/____/___/_/|_| 
    |___/                                                              
==============================================================================
                             README FOR EX2
==============================================================================



CONTENTS
==============================================================================

ex2.jar - contains oop.ex2.main oop.ex2.filecompile and this file.

README:         this file

oop.ex2.main package
CONTENTS:       overall title for contents of locker; can be a 
                single package (e.g., Autocad) or a group (e.g., 
                games)








DESCRIPTION:    brief (1-3 lines) description of software in the 
                locker

HOW TO RUN:     how to access the software

COMMAND:        representative command sequence (at athena% prompt)

FROM DASH:      menu item to select to run program

INTERFACES:     list of available interfaces; possible values:  
                TTY, X11R5, Microsoft Windows, Mac, Openview, etc.

VERSIONS:       version of software according to Athena platform 
                (including version number of software currently 
                installed on specified platform, and listing 
                platform model number as appropriate)

DEPENDENCIES:   list of any significant dependencies of this 
                software on other software (e.g., operating system 
                version), and any significant dependencies of other 
                software on this software

DATAFILES:      indication of whether data files for this software 
                are platform-independent or require conversion 
                between platforms.

LICENSE SERVER: yes (indicate number of floating licenses), or no; 
                if node-locked, specify (e.g., "node locked to 
                major.mit.edu"); may include other specific 
                information for individual cases

----------------------------------------------------------------------

SUPPORT ISSUES --

I/S SUPPORT:

 CONSULTING:    current level of support offered by IS/Athena 
                Consulting, using their support categorizations; 
                options include: unsupported, partially supported, 
                fully supported (may include qualification of 
                category if appropriate, e.g.: "unsupported, but 
                some SIPB support may be available")

 TRAINING:      current level of support offered by IS/Athena 
                Training; options include: none, reference to a 
                specific Athena training course (e.g., "Using 
                Autocad on Athena"), or specialized (e.g., 
                "training for course TA's available from Athena 
                Faculty Liaisons")

 DOCUMENTATION: current I/S Publications documents for this 
                software (or "none"); include On-Line Help (by OLH 
                node-id), man page, internal help in application 
                (with instructions on how to access if available), 
                or Athena documentation (by title and code #).

OTHER SUPPORT:

 CONSULTING:    non-I/S source of consulting (e.g., vendor 1-800 
                number)

 TRAINING:      non-I/S training sources (e.g., software vendor 
                seminars, corporate training companies)

 DOCUMENTATION: vendor manual sets, and relevant textbooks and other 
                materials; if manuals have specific titles and 
                there are not too many, these should be listed by 
                specific title where possible (e.g., "Autocad 
                Release 11 Reference Manual")

BUG REPORTS:    appropriate reporting mechanism, if any exist

----------------------------------------------------------------------

LEGAL ISSUES --

 STATUS:        classification of software type (for legal 
                purposes); options include: Public Domain, 
                Shareware, Commercial, or specialized (e.g., "GNU 
                Copyleft"); if "Commercial", include license 
                summary (currently in file README.license) in 
                remainder of this section.

 SITES:         designated sites for which this software is 
                licensed

 RESTRICTIONS:  specific confidentiality and access restrictions 
                required by license

 DOCUMENTATION: copyright information on vendor documentation

 ADD'L RIGHTS:  additional rights available

 ADD'L CONDITIONS: additional restrictions on usage, or other 
                conditions of use

----------------------------------------------------------------------

ABOUT THIS LOCKER --

MAINTAINER(S):  person(s) responsible for maintenance of this 
                locker, identified as one or more groups, mailing 
                lists, or individuals (indicate which type)

DIRECTORY STRUCTURE: an overview of the major directories in this 
                locker and their contents, with indenting to show 
                the tree structure. Should be as informative as 
                possible without getting too large (e.g., 20-30 
                lines maximum is suggested).

MODIFY HISTORY: list of all significant changes to locker contents 
                in reverse chronological order, including date, 
                person making the modification, and brief listing 
                of nature of the change

MISCELLANEOUS:  any information important to locker users and 
                maintainers that does not easily fit elsewhere; 
                might include additional README files, specialized 
                information, tutorials, etc.

==============================================================================

Example README.athena File


CONTENTS:       Autocad

DESCRIPTION:    Autocad is a general-purpose CAD package that is 
                supported on a wide variety of platforms.

HOW TO RUN:

 COMMAND:       add autocad; autocad

 FROM DASH:     (not available)

INTERFACES:     TTY, X

VERSIONS:       for DECstation:   Autocad version R11
                for RS/6000:      Autocad version R12

DEPENDENCIES:   RS/6000 version requires AIX 3.2 or later to run

DATAFILES:      platform-independent

LICENSE SERVER: yes (4 floating licenses)

----------------------------------------------------------------------

SUPPORT ISSUES --

I/S SUPPORT:

 CONSULTING:    unsupported

 TRAINING:      unsupported

 DOCUMENTATION: Autocad on Athena (AC-137)
                help @autocad:main_menu
                man autocad
                internal help: type help (or ?) at the Command: prompt

OTHER SUPPORT:

 CONSULTING:    (none)

 TRAINING:      (none)

 DOCUMENTATION: Autocad manual set

BUG REPORTS:    send email to bug-acad@mit.edu

----------------------------------------------------------------------

LEGAL ISSUES --


 SITES:         Athena

 DOCUMENTATION: You may not copy the accompanying program 
                documentation.

 ADD'L RIGHTS:  Other MIT users may be able to purchase rights to use
                AutoCAD. Contact Software Acquisition at 253-3700 for 
                details.

 ADD'L CONDITIONS: You may not modify, translate, reverse engineer,
                decompile, disassemble, create derivative works based 
                on or copy the program.

                You may not rent or transfer all or any part of the 
                program or accompanying documentation to any person
                without the prior written consent of Autodesk.

                You may not remove any proprietary notices, labels or 
                marks on the program and accompanying documentation.

                Access to this program is limited to four concurrent 
                users by license server.

----------------------------------------------------------------------

ABOUT THIS LOCKER --

MAINTAINER(S):  swmaint (group)

DIRECTORY STRUCTURE:

  decmipsbin - link to DEC DECstation startup script
  rs6000     - link to IBM RS/6000 startup script (empty now)
  doc        - links to docs
  acad
    acad     - binaries and overlay files
    ads
    api
    igesfont - fonts
    misc
    sample
    slides
    source
  scripts

MODIFY HISTORY: 92/04/17 - R11 DECstation/Ultrix version installed by alexp
                92/03/02 - startup script modified by reidmp
                92/02/01 - R12 RS/6000/AIX version installed by reidmp

MISCELLANEOUS:  For additional information and last-minute changes, 
                see the info in /mit/autocad/doc/readme.doc. There are many 
                commercial books about Autocad. Autocad supports mono,
                grey-scale and color graphics (color recommended for full 
                functionality).

==============================================================================
