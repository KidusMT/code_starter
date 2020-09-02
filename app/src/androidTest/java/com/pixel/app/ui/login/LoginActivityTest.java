package com.pixel.app.ui.login;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.test.InstrumentationRegistry;
import androidx.test.filters.MediumTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.pixel.app.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ALL")
@MediumTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {
//    public final TestComponentRule component =
//            new TestComponentRule(ApplicationProvider.getApplicationContext());

//    public final IntentsTestRule<LoginActivity> main =
//            new IntentsTestRule<>(LoginActivity.class, false, false);

    @Rule
    public ActivityTestRule<LoginActivity> rule = new ActivityTestRule<LoginActivity>(LoginActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            InstrumentationRegistry.getTargetContext();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.putExtra("MYKEY", "Hello");
            return intent;
        }
    };

//    @Rule
//    public TestRule chain = RuleChain.outerRule(component).around(main);

    @Before
    public void setup() {

    }

    @Test
    public void checkViewsDisplay() {
//        main.launchActivity(LoginActivity.getStartIntent(component.getContext()));
        assertTrue(true);
//        onView(withId(R.id.et_username))
//                .check(matches(isDisplayed()));
//
//        onView(withId(R.id.et_password))
//                .check(matches(isDisplayed()));
//
//        onView(withId(R.id.btn_login))
//                .check(matches(isDisplayed()));
//
//        onView(withText(R.string.login))
//                .check(matches(isDisplayed()));

        LoginActivity activity = rule.getActivity();

        View viewById = activity.findViewById(R.id.et_username);

        assertThat(viewById, notNullValue());
        assertThat(viewById, instanceOf(TextView.class));
        TextView textView = (TextView) viewById;
        assertThat(textView.getText().toString(), is("Hello"));
    }
}