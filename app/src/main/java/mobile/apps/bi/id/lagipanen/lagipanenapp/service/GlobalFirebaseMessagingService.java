package mobile.apps.bi.id.lagipanen.lagipanenapp.service;

import android.graphics.Bitmap;

import com.google.firebase.messaging.FirebaseMessagingService;

/**
 * Created by hsn on 01/03/2017.
 */

public class GlobalFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FCM Service";
    Bitmap bitmap;
    /*@Override
    public void onMessageReceived(RemoteMessage remoteMessage) {



        // TODO: Handle FCM messages here.
        // If the application is in the foreground handle both data and notification messages here.
        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated.
        //Log.d(TAG, "From: " + remoteMessage.getFrom());
        //Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());

        //The message which i send will have keys named [message, image, AnotherActivity] and corresponding values.
        //You can change as per the requirement.

        //message will contain the Push Message
        String title = remoteMessage.getData().get("title");
        String id = remoteMessage.getData().get("id");
        String message = remoteMessage.getData().get("message");
        String admin=  remoteMessage.getData().get("admin");
        String type=remoteMessage.getData().get("type");

        //If the key AnotherActivity has  value as True then when the user taps on notification, in the app AnotherActivity will be opened.
        //If the key AnotherActivity has  value as False then when the user taps on notification, in the app MainActivity will be opened.
        //To get a Bitmap image from the URL received
        *//*PrefManager prf = new PrefManager(getApplicationContext());
        if (!prf.getString("notifications").equals("false")){*//*
            if (type.equals("layanan_pengaduan")){
                sendNotificationLayananPengaduan(id,title, message,admin);
            }else if (type.equals("sambungan_baru")) {
                sendNotificationSambunganBaru(id, title, message, admin);
            }else if (type.equals("informasi_gangguan")) {
                sendNotificationInformasiGangguan(id, title, message, admin);
            }else {
                String video =remoteMessage.getData().get("video");
                *//*sendNotificationVideo(id,title, imageUri,time,category,video,comment);*//*
            }
        *//*}*//*
    }
    *//*
    private void sendNotificationVideo(String id, String title, String imageUri, String time, String category, String video, String comment) {

        Bitmap image = getBitmapfromUrl(imageUri);
        Intent intent = new Intent(this, VideoActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("id_article",id);
        intent.putExtra("title_article",title);
        intent.putExtra("image_article",imageUri);
        intent.putExtra("created_article",time);
        intent.putExtra("video_article",video);
        intent.putExtra("comment_article",comment);
        intent.putExtra("category_article",category);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 *//**//**//**//**//**//**//**//* Request code *//**//**//**//**//**//**//**//*, intent,
                PendingIntent.FLAG_ONE_SHOT);


        RemoteViews remoteViews = new RemoteViews(getPackageName(),
                R.layout.custom_notification);
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        remoteViews.setImageViewBitmap(R.id.image_view_notif_item,image);
        remoteViews.setTextViewText(R.id.text_View_title_notif_item,title);
        remoteViews.setTextViewText(R.id.text_view_time_notif_item,time);
        remoteViews.setTextViewText(R.id.text_view_category_notif_item,category);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setLargeIcon(image)*//**//**//**//**//**//**//**//*Notification icon image*//**//**//**//**//**//**//**//*
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
                .setCustomBigContentView(remoteViews)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(image))
                ;


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(Integer.parseInt(id) *//**//**//**//**//**//**//**//* ID of notification *//**//**//**//**//**//**//**//*, notificationBuilder.build());
    }
*//*
    private void sendNotificationLayananPengaduan(String id, String title, String message, String admin) {

        Intent intent = new Intent(this, DetailLayananPengaduanActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        intent.putExtra("id",id);
*//*        intent.putExtra("title",title);
        intent.putExtra("image_article",imageUri);
        intent.putExtra("created_article",time);
        intent.putExtra("comment_article",comment);*//*

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 *//* Request code *//*, intent,
                PendingIntent.FLAG_ONE_SHOT);



        RemoteViews remoteViews = new RemoteViews(getPackageName(),
                R.layout.custom_notification);
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.notif);

        remoteViews.setTextViewText(R.id.text_view_title_notif_item,title);
        remoteViews.setTextViewText(R.id.text_view_admin_notif_item,admin);
        remoteViews.setTextViewText(R.id.text_View_message_notif_item,message);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
//                .setLargeIcon(largeIcon) *//*Notification icon image*//*
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setColorized(true)
                .setContentTitle(title)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
                .setCustomBigContentView(remoteViews)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(message));


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(Integer.parseInt(id) *//* ID of notification *//*, notificationBuilder.build());
    }

    private void sendNotificationSambunganBaru(String id, String title, String message, String admin) {

        Intent intent = new Intent(this, DetailSambunganBaruActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        intent.putExtra("id",id);
*//*        intent.putExtra("title",title);
        intent.putExtra("image_article",imageUri);
        intent.putExtra("created_article",time);
        intent.putExtra("comment_article",comment);*//*

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 *//* Request code *//*, intent,
                PendingIntent.FLAG_ONE_SHOT);

        RemoteViews remoteViews = new RemoteViews(getPackageName(),
                R.layout.custom_notification);
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round);

        remoteViews.setTextViewText(R.id.text_view_title_notif_item,title);
        remoteViews.setTextViewText(R.id.text_view_admin_notif_item,admin);
        remoteViews.setTextViewText(R.id.text_View_message_notif_item,message);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                *//*.setLargeIcon(image)*//* *//*Notification icon image*//*
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle(title)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
                .setCustomBigContentView(remoteViews)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(message));


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(Integer.parseInt(id) *//* ID of notification *//*, notificationBuilder.build());
    }

    private void sendNotificationInformasiGangguan(String id, String title, String message, String admin) {

        Intent intent = new Intent(this, DetailSambunganBaruActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        intent.putExtra("id",id);
*//*        intent.putExtra("title",title);
        intent.putExtra("image_article",imageUri);
        intent.putExtra("created_article",time);
        intent.putExtra("comment_article",comment);*//*

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 *//* Request code *//*, intent,
                PendingIntent.FLAG_ONE_SHOT);

        RemoteViews remoteViews = new RemoteViews(getPackageName(),
                R.layout.custom_notification);
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round);

        remoteViews.setTextViewText(R.id.text_view_title_notif_item,title);
        remoteViews.setTextViewText(R.id.text_view_admin_notif_item,admin);
        remoteViews.setTextViewText(R.id.text_View_message_notif_item,message);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                *//*.setLargeIcon(image)*//* *//*Notification icon image*//*
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle(title)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
                .setCustomBigContentView(remoteViews)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(message));


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(Integer.parseInt(id) *//* ID of notification *//*, notificationBuilder.build());
    }

    public Bitmap getBitmapfromUrl(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            return bitmap;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;

        }
    }*/



}