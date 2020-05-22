import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxUploader;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.CreateFolderErrorException;
import com.dropbox.core.v2.files.CreateFolderResult;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.WriteMode;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.InputStream;

class BasicDropBoxImpl {

    private static DbxClientV2 client = null;

    static void init() {
        final DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/test").build();
        client = new DbxClientV2(config, "fXKODA7l-nAAAAAAAAAA8j85yYWhHjQiWiRX9-kL7rM0kUNIDQXBoHipPF7pzktp");
    }

    @SneakyThrows
    static void createDirectory(final String dirName) {
        final CreateFolderResult folderResult = client.files().createFolderV2(dirName);
    }

    @SneakyThrows
    static InputStream download(final String path) {
        final DbxDownloader<FileMetadata> downloader = client.files().download(path);
        return downloader.getInputStream();
    }

    @SneakyThrows
    static void upload(final String from, final String to) {
        final FileInputStream is = new FileInputStream(from);
        client.files().uploadBuilder(to).withMode(WriteMode.ADD).uploadAndFinish(is);
    }

    @SneakyThrows
    static void copyFile(final String from, final String to) {
        client.files().copyV2(from, to);
    }

    @SneakyThrows
    static  void delete(final String path) {
        client.files().deleteV2(path);
    }
}
