package com.girish.activity;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.girish.notes.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NotesActivityTest {

    @Rule
    public ActivityTestRule<NotesActivity> mActivityTestRule = new ActivityTestRule<>(NotesActivity.class);

    @Test
    public void notesActivityTest() {
        ViewInteraction imageButton = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        imageButton.check(matches(isDisplayed()));

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.title), isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.title), isDisplayed()));
        appCompatEditText2.perform(replaceText("Testing "));

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.description), isDisplayed()));
        appCompatEditText3.perform(replaceText("testing design "));

        pressBack();

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.fab),
                        withParent(allOf(withId(R.id.activity_add_notes),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recycle_view), isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction floatingActionButton3 = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton3.perform(click());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.contentEditTextview), withText("testing design "),
                        withParent(withId(R.id.view_switcher)),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("testing design edited "));

        pressBack();

        ViewInteraction floatingActionButton4 = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton4.perform(click());

        ViewInteraction floatingActionButton5 = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton5.perform(click());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.title), isDisplayed()));
        appCompatEditText5.perform(click());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.title), isDisplayed()));
        appCompatEditText6.perform(replaceText("delete "));

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.description), isDisplayed()));
        appCompatEditText7.perform(replaceText("Dr "));

        ViewInteraction floatingActionButton6 = onView(
                allOf(withId(R.id.fab),
                        withParent(allOf(withId(R.id.activity_add_notes),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        floatingActionButton6.perform(click());

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.delete_imageview), isDisplayed()));
        appCompatImageView.perform(click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(android.R.id.button1), withText("Yes"),
                        withParent(allOf(withClassName(is("com.android.internal.widget.ButtonBarLayout")),
                                withParent(withClassName(is("android.widget.LinearLayout"))))),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction floatingActionButton7 = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton7.perform(click());

        ViewInteraction floatingActionButton8 = onView(
                allOf(withId(R.id.fab),
                        withParent(allOf(withId(R.id.activity_add_notes),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        floatingActionButton8.perform(click());

        ViewInteraction imageButton2 = onView(
                allOf(withContentDescription("Navigate up"),
                        withParent(allOf(withId(R.id.toolbar),
                                withParent(withId(R.id.activity_add_notes)))),
                        isDisplayed()));
        imageButton2.perform(click());

    }
}
