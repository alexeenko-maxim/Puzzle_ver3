package braingame.amax.puzzle;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

public class GestureDetectGridView38 extends GridView {

    private static GestureDetector gDetector;
    private boolean mFlingConfirmed = false;
    private float mTouchX;
    private float mTouchY;
    private static  final  int SWIPE_MIN_DISTANCE = 100;
    private static  final  int SWIPE_MAX_OFF_PATH = 100;
    private static  final  int SWIPE_THRESHOLD_VELOCITY = 100;


    public GestureDetectGridView38(Context context) {
        super(context);
        init(context);
    }

    public GestureDetectGridView38(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GestureDetectGridView38(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP) // API 21
    public GestureDetectGridView38(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(final Context context) {
        gDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onDown (MotionEvent event) {

            return true;
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                final int position = GestureDetectGridView38.this.pointToPosition(Math.round(e1.getX()), Math.round(e1.getY()));

                if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH) {
                    if (Math.abs(e1.getX() - e2.getX()) > SWIPE_MAX_OFF_PATH || Math.abs(velocityY) < SWIPE_THRESHOLD_VELOCITY) {
                        return false;
                    }
                    if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE) {
                        try {
                            Level_038.moveTilesLvl_038(context, Level_038.UP, position);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE) {
                        try {
                            Level_038.moveTilesLvl_038(context, Level_038.DOWN, position);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    if (Math.abs(velocityX) < SWIPE_THRESHOLD_VELOCITY) {
                        return false;
                    }
                    if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE) {
                        try {
                            Level_038.moveTilesLvl_038(context, Level_038.LEFT, position);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE) {
                        try {
                            Level_038.moveTilesLvl_038(context, Level_038.RIGHT, position);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });
    }

@Override
    public boolean onInterceptTouchEvent (MotionEvent ev) {
        int action = ev.getActionMasked();
        gDetector.onTouchEvent(ev);

    if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
        mFlingConfirmed = false;
    } else if (action == MotionEvent.ACTION_DOWN) {
        mTouchX = ev.getX();
        mTouchY = ev.getY();
    } else {
        if (mFlingConfirmed) {
            return true;
        }
        float dX = (Math.abs(ev.getX() - mTouchX));
        float dY = (Math.abs(ev.getY() - mTouchY));
        if ((dX > SWIPE_MIN_DISTANCE) || (dY > SWIPE_MIN_DISTANCE)) {
            mFlingConfirmed = true;
            return true;
        }
    }
    return super.onInterceptTouchEvent(ev);
}

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return gDetector.onTouchEvent(ev);

    }
}

class CustomAdapter38 extends BaseAdapter {

    private ArrayList<Button> mButtons;
    private int mColumnWidth, mColumnHeight;

    public CustomAdapter38(ArrayList<Button> buttons, int columnWidth, int columnHeight) {
        mButtons = buttons;
        mColumnWidth = columnWidth;
        mColumnHeight = columnHeight;
    }

    @Override
    public int getCount() {
        return mButtons.size();
    }

    @Override
    public Object getItem(int position) {return (Object) mButtons.get(position);}

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Button button;

        if (convertView == null){
            button = mButtons.get(position);
        }
        else {
            button = (Button) convertView;
        }

        android.widget.AbsListView.LayoutParams params =
                new android.widget.AbsListView.LayoutParams(mColumnWidth, mColumnHeight);
        button.setLayoutParams(params);
        return button;
    }
}
