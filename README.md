### NTFSFIX-GUI

That's an overlay for ntfsfix. The Linux NTFS console repairing program.
### Introduce 
Today I have some easy usefull overlay for generic (for some distributions) Linux tool called ntfsfix. That's nice console tool that can repair NTFS partition destroyed for example by incorrect unmount. 
For make using this tool  easier I created graphical overlay for it. That's perfect for people who don't want use console or were beginners in Linux system.

### Features
* Finding connected drives
* Starting ntfsfix with *Clear bad sector list flag*
* Starting ntfsfix with  *Clear the volume dirty flag*
* Direct output from ntfsfix in output window.

### Technology Stack
* Java 8 
* JavaFX (FXML)
* Linux Bash Command for launching ntfsfix tool

### Screenshots
![proof_of_work.png](https://res.cloudinary.com/hpiynhbhq/image/upload/v1520276507/uaj8qxfyi7zztvswu0sq.png)

### Dependencies
* ntfsfix (console tool)  
* kdesu or gksudo

### Installation
1. Download ntfs-gui_stable-x.x.x.tar.gz from [here](https://github.com/dominico2000/NTFSFIX-GUI/releases) package and untar it using following command:  `tar -zxvf ntfs-gui_stable-x.x.x.tar.gz`

2. Make sure that you have *ntfsfix* and *kdesu* or *gksudo*. If you don't install it.

3.  Run *install* script with root. You can do it usually by using:  ` sudo ./install`

4. Install script ask you what kind of graphical authentication do you wan't to use (kdesu or gksudo).

5. Gratulations! *Ntfsfix-gui* is installed on your computer. Now you can run it by call `ntfsfix-gui` or create shortcut for it.

### Problems

If you have any problems with my app you can contact with me on Discord by dominico2000#8230.

### How to contribute
If you want to contribute that project you can make Pull Request or contact with me on Discord by dominico2000#8230.
