/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.ProgressBar
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 *  butterknife.Unbinder
 *  butterknife.internal.Finder
 *  butterknife.internal.ViewBinder
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.becandid.candid.views.viewholders;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.becandid.candid.views.viewholders.BasePostViewHolder;

public class BasePostViewHolder$$ViewBinder<T extends BasePostViewHolder>
implements ViewBinder<T> {
    public Unbinder a(Finder finder, T t2, Object object) {
        a<T> a2 = this.a(t2);
        t2.mLikeRumorPostContainer = (LinearLayout)finder.castView((View)finder.findRequiredView(object, 2131624737, "field 'mLikeRumorPostContainer'"), 2131624737, "field 'mLikeRumorPostContainer'");
        t2.mLikeRumorPostIcon = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624739, "field 'mLikeRumorPostIcon'"), 2131624739, "field 'mLikeRumorPostIcon'");
        t2.mLikeRumorPostText = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624742, "field 'mLikeRumorPostText'"), 2131624742, "field 'mLikeRumorPostText'");
        t2.mLikeRumorPostBadge = (LinearLayout)finder.castView((View)finder.findRequiredView(object, 2131624741, "field 'mLikeRumorPostBadge'"), 2131624741, "field 'mLikeRumorPostBadge'");
        t2.mRumorTrueText = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624740, "field 'mRumorTrueText'"), 2131624740, "field 'mRumorTrueText'");
        t2.mUnlikeRumorPostContainer = (LinearLayout)finder.castView((View)finder.findRequiredView(object, 2131624743, "field 'mUnlikeRumorPostContainer'"), 2131624743, "field 'mUnlikeRumorPostContainer'");
        t2.mUnlikeRumorPostIcon = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624745, "field 'mUnlikeRumorPostIcon'"), 2131624745, "field 'mUnlikeRumorPostIcon'");
        t2.mUnlikeRumorPostText = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624748, "field 'mUnlikeRumorPostText'"), 2131624748, "field 'mUnlikeRumorPostText'");
        t2.mUnlikeRumorPostBadge = (LinearLayout)finder.castView((View)finder.findRequiredView(object, 2131624747, "field 'mUnlikeRumorPostBadge'"), 2131624747, "field 'mUnlikeRumorPostBadge'");
        t2.mRumorFalseText = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624746, "field 'mRumorFalseText'"), 2131624746, "field 'mRumorFalseText'");
        t2.mCommentPostContainer = (LinearLayout)finder.castView((View)finder.findRequiredView(object, 2131624749, "field 'mCommentPostContainer'"), 2131624749, "field 'mCommentPostContainer'");
        t2.mCommentPostBadge = (LinearLayout)finder.castView((View)finder.findRequiredView(object, 2131624751, "field 'mCommentPostBadge'"), 2131624751, "field 'mCommentPostBadge'");
        t2.mCommentPostText = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624752, "field 'mCommentPostText'"), 2131624752, "field 'mCommentPostText'");
        t2.mShareButton = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624753, "field 'mShareButton'"), 2131624753, "field 'mShareButton'");
        t2.mShareIcon = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624754, "field 'mShareIcon'"), 2131624754, "field 'mShareIcon'");
        t2.mMessagePostContainer = (LinearLayout)finder.castView((View)finder.findRequiredView(object, 2131624755, "field 'mMessagePostContainer'"), 2131624755, "field 'mMessagePostContainer'");
        t2.mPostAuthor = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624769, "field 'mPostAuthor'"), 2131624769, "field 'mPostAuthor'");
        t2.mPostIcon = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624766, "field 'mPostIcon'"), 2131624766, "field 'mPostIcon'");
        t2.mPostModIcon = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624767, "field 'mPostModIcon'"), 2131624767, "field 'mPostModIcon'");
        t2.mPostGroup = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624779, "field 'mPostGroup'"), 2131624779, "field 'mPostGroup'");
        t2.mPostGroupContainer = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624776, "field 'mPostGroupContainer'"), 2131624776, "field 'mPostGroupContainer'");
        t2.mPostGroupMenu = (View)finder.findRequiredView(object, 2131624778, "field 'mPostGroupMenu'");
        t2.mPostGroupMenuContainer = (RelativeLayout)finder.castView((View)finder.findRequiredView(object, 2131624777, "field 'mPostGroupMenuContainer'"), 2131624777, "field 'mPostGroupMenuContainer'");
        t2.mPostTimestamp = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624774, "field 'mPostTimestamp'"), 2131624774, "field 'mPostTimestamp'");
        t2.mFooter = (View)finder.findRequiredView(object, 2131624267, "field 'mFooter'");
        t2.mHeader = (View)finder.findRequiredView(object, 2131624264, "field 'mHeader'");
        t2.mPostPopupAction = (View)finder.findRequiredView(object, 2131624768, "field 'mPostPopupAction'");
        t2.mPostHeaderBadge = (View)finder.findRequiredView(object, 2131624770, "field 'mPostHeaderBadge'");
        t2.mPostHeaderBadgeText = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624771, "field 'mPostHeaderBadgeText'"), 2131624771, "field 'mPostHeaderBadgeText'");
        t2.mPostHeaderBadgeScore = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624773, "field 'mPostHeaderBadgeScore'"), 2131624773, "field 'mPostHeaderBadgeScore'");
        t2.mPostHeaderBadgeDot = (FrameLayout)finder.castView((View)finder.findRequiredView(object, 2131624772, "field 'mPostHeaderBadgeDot'"), 2131624772, "field 'mPostHeaderBadgeDot'");
        t2.reportFlag = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624775, "field 'reportFlag'"), 2131624775, "field 'reportFlag'");
        t2.mFooterCommentIcon = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624760, "field 'mFooterCommentIcon'"), 2131624760, "field 'mFooterCommentIcon'");
        t2.mFooterCommentModIcon = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624761, "field 'mFooterCommentModIcon'"), 2131624761, "field 'mFooterCommentModIcon'");
        t2.mFooterCommentImage = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624763, "field 'mFooterCommentImage'"), 2131624763, "field 'mFooterCommentImage'");
        t2.mFooterCommentTimestamp = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624762, "field 'mFooterCommentTimestamp'"), 2131624762, "field 'mFooterCommentTimestamp'");
        t2.mFooterCommentText = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624764, "field 'mFooterCommentText'"), 2131624764, "field 'mFooterCommentText'");
        t2.mFooterCommentSnippet = (View)finder.findRequiredView(object, 2131624757, "field 'mFooterCommentSnippet'");
        t2.mFooterCommentValue = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624758, "field 'mFooterCommentValue'"), 2131624758, "field 'mFooterCommentValue'");
        t2.mPostContainer = (LinearLayout)finder.castView((View)finder.findRequiredView(object, 2131624401, "field 'mPostContainer'"), 2131624401, "field 'mPostContainer'");
        t2.mPostRelated = (LinearLayout)finder.castView((View)finder.findRequiredView(object, 2131624797, "field 'mPostRelated'"), 2131624797, "field 'mPostRelated'");
        t2.mPostRelatedBottom = (LinearLayout)finder.castView((View)finder.findRequiredView(object, 2131624800, "field 'mPostRelatedBottom'"), 2131624800, "field 'mPostRelatedBottom'");
        t2.mPostRelatedBar = (View)finder.findRequiredView(object, 2131624400, "field 'mPostRelatedBar'");
        t2.mPostTrending = (View)finder.findRequiredView(object, 2131624804, "field 'mPostTrending'");
        t2.mPostRumorAlert = (View)finder.findRequiredView(object, 2131624801, "field 'mPostRumorAlert'");
        t2.mPostTrendingDrawable = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624805, "field 'mPostTrendingDrawable'"), 2131624805, "field 'mPostTrendingDrawable'");
        t2.mPostTrendingText = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624806, "field 'mPostTrendingText'"), 2131624806, "field 'mPostTrendingText'");
        t2.mPostRumorAlertDrawable = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624802, "field 'mPostRumorAlertDrawable'"), 2131624802, "field 'mPostRumorAlertDrawable'");
        t2.mPostRumorAlertText = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624803, "field 'mPostRumorAlertText'"), 2131624803, "field 'mPostRumorAlertText'");
        t2.mPostCaption = (TextView)finder.castView((View)finder.findOptionalView(object, 2131624115, null), 2131624115, "field 'mPostCaption'");
        t2.mProgressBar = (ProgressBar)finder.castView((View)finder.findRequiredView(object, 2131624191, "field 'mProgressBar'"), 2131624191, "field 'mProgressBar'");
        t2.mPostShareOgImage = (View)finder.findRequiredView(object, 2131624408, "field 'mPostShareOgImage'");
        t2.mPostGroupOgImage = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624795, "field 'mPostGroupOgImage'"), 2131624795, "field 'mPostGroupOgImage'");
        t2.mPostCaptionOgImage = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624411, "field 'mPostCaptionOgImage'"), 2131624411, "field 'mPostCaptionOgImage'");
        t2.mLikePostBtnOgImage = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624783, "field 'mLikePostBtnOgImage'"), 2131624783, "field 'mLikePostBtnOgImage'");
        t2.mUnlikePostBtnOgImage = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624788, "field 'mUnlikePostBtnOgImage'"), 2131624788, "field 'mUnlikePostBtnOgImage'");
        t2.mTrueRumorTextOgImage = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624786, "field 'mTrueRumorTextOgImage'"), 2131624786, "field 'mTrueRumorTextOgImage'");
        t2.mFalseRumorTextOgImage = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624791, "field 'mFalseRumorTextOgImage'"), 2131624791, "field 'mFalseRumorTextOgImage'");
        t2.mTrueRumorIconOgImage = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624785, "field 'mTrueRumorIconOgImage'"), 2131624785, "field 'mTrueRumorIconOgImage'");
        t2.mFalseRumorIconOgImage = (ImageView)finder.castView((View)finder.findRequiredView(object, 2131624790, "field 'mFalseRumorIconOgImage'"), 2131624790, "field 'mFalseRumorIconOgImage'");
        t2.mCommentPostBtnOgImage = (TextView)finder.castView((View)finder.findRequiredView(object, 2131624793, "field 'mCommentPostBtnOgImage'"), 2131624793, "field 'mCommentPostBtnOgImage'");
        t2.mTrueRumorContainerOgImage = (View)finder.findRequiredView(object, 2131624784, "field 'mTrueRumorContainerOgImage'");
        t2.mFalseRumorContainerOgImage = (View)finder.findRequiredView(object, 2131624789, "field 'mFalseRumorContainerOgImage'");
        t2.mPostImageFooter = (View)finder.findRequiredView(object, 2131624413, "field 'mPostImageFooter'");
        return a2;
    }

    protected a<T> a(T t2) {
        return new a<T>(t2);
    }

    public /* synthetic */ Unbinder bind(Finder finder, Object object, Object object2) {
        return this.a(finder, (T)((Object)((BasePostViewHolder)((Object)object))), object2);
    }

    public static class a<T extends BasePostViewHolder>
    implements Unbinder {
        private T a;

        protected a(T t2) {
            this.a = t2;
        }

        protected void a(T t2) {
            t2.mLikeRumorPostContainer = null;
            t2.mLikeRumorPostIcon = null;
            t2.mLikeRumorPostText = null;
            t2.mLikeRumorPostBadge = null;
            t2.mRumorTrueText = null;
            t2.mUnlikeRumorPostContainer = null;
            t2.mUnlikeRumorPostIcon = null;
            t2.mUnlikeRumorPostText = null;
            t2.mUnlikeRumorPostBadge = null;
            t2.mRumorFalseText = null;
            t2.mCommentPostContainer = null;
            t2.mCommentPostBadge = null;
            t2.mCommentPostText = null;
            t2.mShareButton = null;
            t2.mShareIcon = null;
            t2.mMessagePostContainer = null;
            t2.mPostAuthor = null;
            t2.mPostIcon = null;
            t2.mPostModIcon = null;
            t2.mPostGroup = null;
            t2.mPostGroupContainer = null;
            t2.mPostGroupMenu = null;
            t2.mPostGroupMenuContainer = null;
            t2.mPostTimestamp = null;
            t2.mFooter = null;
            t2.mHeader = null;
            t2.mPostPopupAction = null;
            t2.mPostHeaderBadge = null;
            t2.mPostHeaderBadgeText = null;
            t2.mPostHeaderBadgeScore = null;
            t2.mPostHeaderBadgeDot = null;
            t2.reportFlag = null;
            t2.mFooterCommentIcon = null;
            t2.mFooterCommentModIcon = null;
            t2.mFooterCommentImage = null;
            t2.mFooterCommentTimestamp = null;
            t2.mFooterCommentText = null;
            t2.mFooterCommentSnippet = null;
            t2.mFooterCommentValue = null;
            t2.mPostContainer = null;
            t2.mPostRelated = null;
            t2.mPostRelatedBottom = null;
            t2.mPostRelatedBar = null;
            t2.mPostTrending = null;
            t2.mPostRumorAlert = null;
            t2.mPostTrendingDrawable = null;
            t2.mPostTrendingText = null;
            t2.mPostRumorAlertDrawable = null;
            t2.mPostRumorAlertText = null;
            t2.mPostCaption = null;
            t2.mProgressBar = null;
            t2.mPostShareOgImage = null;
            t2.mPostGroupOgImage = null;
            t2.mPostCaptionOgImage = null;
            t2.mLikePostBtnOgImage = null;
            t2.mUnlikePostBtnOgImage = null;
            t2.mTrueRumorTextOgImage = null;
            t2.mFalseRumorTextOgImage = null;
            t2.mTrueRumorIconOgImage = null;
            t2.mFalseRumorIconOgImage = null;
            t2.mCommentPostBtnOgImage = null;
            t2.mTrueRumorContainerOgImage = null;
            t2.mFalseRumorContainerOgImage = null;
            t2.mPostImageFooter = null;
        }

        public final void unbind() {
            if (this.a == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a(this.a);
            this.a = null;
        }
    }

}

