import java.io.File;

public class Files_Sorter {

	// static Map<String, String> runnables = ImmutableMap.of("EXE","EXE");
	static String[] Images = { "JPG", "PNG", "GIF", "WEBP", "TIFF", "PSD", "RAW", "BMP", "HEIF", "INDD", "JPEG" };
	static String[] Docs = { "DOCX", "DOC", "PDF", "HTML", "ODT", "XLS", "XLSX", "PPT", "PPTX", "ODS", "TXT", "CSV" };
	static String[] Sounds = {"MP3","WMA","AAC","WAV", "FLAC","AIF"};
	static String[] Vids = {"WEBM","MPG","MP2","MPEG","MPE","MPV","OGG","MP4","M4P","M4V","AVI","WMV","MOV","QT","FLV","SWF","AVCHD"};
	static String[] Zips = {"ZIP","SITX","7Z","RAR", "GZ"};
	static String[] Runnables = {"EXE","LNK"};

	public static void main(String[] args) {
		String dir = "";
		if(args.length == 0){
			dir = System.getProperty("user.dir");
		}else{
			dir = args[0];
		}
		System.out.println("DIRECTORY: "+dir);
		sorter(dir);

	}

	public static void sorter(String folder){
		boolean found = false;
		boolean a,b,c,d,e,g;
		a=b=c=d=e=g= false;
		new File(folder+"/ZIPS").mkdirs();// create zips dir if not found
		File directory = new File(folder);
		File[] contents = directory.listFiles();
		System.out.println("NUMBER OF FILES/FOLDER: "+contents.length);
		for ( File f : contents) {
			//System.out.println(f.getAbsolutePath());
			found = false;
			String file_name = f.getName();
			int i = file_name.lastIndexOf(".");
			if(i > 0){
				String ext = file_name.substring(i+1);
				for(String app: Runnables){
					if(app.equalsIgnoreCase(ext)){ // executable files
						if(!a){
							new File(folder+"/EXE").mkdirs(); // create EXE dir if not found
							a = true;
						}
						System.out.println(folder+"/EXE/"+f.getName());
						f.renameTo(new File(folder+"/EXE/"+f.getName()));
						found = true;
					}
				}

				if(!found){
					for(String img : Images){	// find all images in folder
						if(img.equalsIgnoreCase(ext)){
							if(!b){
								new File(folder+"/IMAGES").mkdirs(); // create images dir if not found
								b = true;
							}
							//System.out.println(file_name+" "+ ext);
							System.out.println(folder+"/IMAGES/"+f.getName());
							f.renameTo(new File(folder+"/IMAGES/"+f.getName()));
							found = true;
							break;
						}
					}
				}
				if(!found){
					for(String sound : Sounds){	// find all sounds in folder
						if(sound.equalsIgnoreCase(ext)){
							if(!c){
								new File(folder+"/MUSIC").mkdirs(); // create sound dir if not found
								c = true;
							}
							//System.out.println(file_name+" "+ ext);
							System.out.println(folder+"/MUSIC/"+f.getName());
							f.renameTo(new File(folder+"/MUSIC/"+f.getName()));
							found = true;
							break;
						}
					}
				}

				if(!found){
					for(String doc : Docs){	// find all docs in folder
						if(doc.equalsIgnoreCase(ext)){
							if(!d){
								new File(folder+"/DOCUMENTS").mkdirs(); // create docs dir if not found
								d = true;
							}
							//System.out.println(file_name+" "+ ext);
							System.out.println(folder+"/DOCUMENTS/"+f.getName());
							f.renameTo(new File(folder+"/DOCUMENTS/"+f.getName()));
							found = true;
							break;
						}
					}
				}
				if(!found){
					for(String vid : Vids){	// find all vids in folder
						if(vid.equalsIgnoreCase(ext)){
							if(!e){
								new File(folder+"/VIDEOS").mkdirs(); // create images vids if not found
								e = true;
							}
							//System.out.println(file_name+" "+ ext);
							System.out.println(folder+"/VIDEOS/"+f.getName());
							f.renameTo(new File(folder+"/VIDEOS/"+f.getName()));
							found = true;
							break;
						}
					}
				}

				if(!found){
					for(String zip : Zips){	// find all zips in folder
						if(zip.equalsIgnoreCase(ext)){
							if(!g){
								new File(folder+"/ZIPS").mkdirs(); // create images dir if not found
								g = true;
							}
							//System.out.println(file_name+" "+ ext);
							System.out.println(folder+"/ZIPS/"+f.getName());
							f.renameTo(new File(folder+"/ZIPS/"+f.getName()));
							found = true;
							break;
						}
					}
				}
			}

		}
	}

}
