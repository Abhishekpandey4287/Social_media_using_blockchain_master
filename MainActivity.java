public class NotificationActivity extends AppCompatActivity {

    private ListView notificationListView;
    private NotificationAdapter notificationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_layout);

        notificationListView = findViewById(R.id.notificationListView);
        notificationAdapter = new NotificationAdapter(this, getSampleNotifications());
        notificationListView.setAdapter(notificationAdapter);
    }

    // Sample notification data
    private List<Notification> getSampleNotifications() {
        List<Notification> notifications = new ArrayList<>();
        notifications.add(new Notification("User A liked your photo."));
        notifications.add(new Notification("User B started following you."));
        notifications.add(new Notification("User C commented on your post."));
        // Add more notifications as needed
        return notifications;
    }
}

class Notification {
    private String message;

    public Notification(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

class NotificationAdapter extends ArrayAdapter<Notification> {
    private Context context;

    public NotificationAdapter(Context context, List<Notification> notifications) {
        super(context, 0, notifications);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.notification_item, parent, false);
        }

        Notification notification = getItem(position);

        ImageView notificationImage = convertView.findViewById(R.id.notificationImage);
        TextView notificationText = convertView.findViewById(R.id.notificationText);

        // Customize notification appearance if needed
        notificationImage.setImageResource(R.drawable.notification_icon);
        notificationText.setText(notification.getMessage());

        return convertView;
    }
}
