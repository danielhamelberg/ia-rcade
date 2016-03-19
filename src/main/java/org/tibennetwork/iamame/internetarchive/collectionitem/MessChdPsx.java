package org.tibennetwork.iamame.internetarchive.collectionitem;

import java.io.File;
import java.util.List;

import org.tibennetwork.iamame.mame.Software;

public class MessChdPsx extends SoftwareListCollectionItem {

    private String softwareFileUrlPattern 
        = "http://archive.org/download/MESS_0.149_CHD_psx/" 
            + "MESS_0.149_CHD_psx.zip/MESS_0.149_CHD_psx/%1$s/%2$s.chd";

    public MessChdPsx (List<File> romsPaths, File writableRomPath) {
        super(romsPaths, writableRomPath);
    }

    public void download (Software software) 
            throws FileNotFoundInCollectionItem {
        
        String softwareName = software.getName();
        String chdName = software.getChdName();
        
        String softwareFileUrl = String.format(
            this.softwareFileUrlPattern,
            softwareName,
            chdName);

        String destinationPath = this.writableRomPath.getAbsolutePath()
            + File.separator
            + software.getRelativeFilePath();

        this.downloadFile(softwareFileUrl, destinationPath);

    }

}