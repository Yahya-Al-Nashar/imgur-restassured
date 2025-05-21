import org.testng.annotations.Test;

public class DemoTests{

    @Test
    public void happyScenario()
    {
        LimitReq.limit(true,200);

        Img1Req.uploadImg1(true,200);
        Img1Req.getImg1(true,200);
        ShareReq.shareImg1(true,200);

        Img2Req.uploadImg2(true,200);
        Img2Req.getImg2(true,200);
        ShareReq.shareImg2(true,200);

        AlbumReq.uploadAlbum(true,200);
        AlbumReq.getAlbum(true,200);
        AlbumReq.updateAlbum(true,200);

        CommentReq.uploadComment(true,200);
        CommentReq.getComment(true,200);

        CommentReq.deleteComment(true,200);
        AlbumReq.deleteAlbum(true,200);
        Img2Req.deleteImg2(true,200);
        Img1Req.deleteImg1(true,200);
    }

    @Test
    public void invalidScenarioComment()
    {
        LimitReq.limit(true,200);

        Img1Req.uploadImg1(true,200);
        Img1Req.getImg1(true,200);

        Img2Req.uploadImg2(true,200);
        Img2Req.getImg2(true,200);

        AlbumReq.uploadAlbum(true,200);
        AlbumReq.getAlbum(true,200);
        AlbumReq.updateAlbum(true,200);

        CommentReq.uploadComment(false,400);

        ShareReq.shareImg1(true,200);
        ShareReq.shareImg2(true,200);

        CommentReq.getComment(false,400);

        CommentReq.deleteComment(false,400);
        AlbumReq.deleteAlbum(true,200);
        Img2Req.deleteImg2(true,200);
        Img1Req.deleteImg1(true,200);
    }

    @Test
    public void invalidScenarioGet()
    {
        LimitReq.limit(true,200);

        Img1Req.uploadImg1(true,200);
        Img2Req.uploadImg2(true,200);

        AlbumReq.uploadAlbum(true,200);
        AlbumReq.updateAlbum(true,200);

        ShareReq.shareImg1(true,200);
        ShareReq.shareImg2(true,200);

        CommentReq.uploadComment(true,200);
        CommentReq.getComment(true,200);

        CommentReq.deleteComment(true,200);
        AlbumReq.deleteAlbum(true,200);
        Img2Req.deleteImg2(true,200);
        Img1Req.deleteImg1(true,200);

        Img1Req.getImg1(false,404);
        Img2Req.getImg2(false,404);
        AlbumReq.getAlbum(false,404);


    }
}
