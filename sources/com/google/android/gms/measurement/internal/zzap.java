package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.gms.internal.measurement.zzbz;
import com.google.android.gms.internal.measurement.zzck;
import com.google.android.gms.internal.measurement.zzjf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzap {
    public static zzeu<Long> zza = zza("measurement.ad_id_cache_time", 10000L, 10000L, zzas.zza);
    public static zzeu<Long> zzaa = zza("measurement.upload.retry_time", 1800000L, 1800000L, zzbo.zza);
    public static zzeu<Integer> zzab = zza("measurement.upload.retry_count", 6, 6, zzbn.zza);
    public static zzeu<Long> zzac = zza("measurement.upload.max_queue_time", 2419200000L, 2419200000L, zzbq.zza);
    public static zzeu<Integer> zzad = zza("measurement.lifetimevalue.max_currency_tracked", 4, 4, zzbp.zza);
    public static zzeu<Integer> zzae;
    public static zzeu<Long> zzaf = zza("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, zzbu.zza);
    public static zzeu<Boolean> zzag = zza("measurement.test.boolean_flag", false, false, zzbt.zza);
    public static zzeu<String> zzah = zza("measurement.test.string_flag", "---", "---", zzbw.zza);
    public static zzeu<Long> zzai = zza("measurement.test.long_flag", -1L, -1L, zzbv.zza);
    public static zzeu<Integer> zzaj = zza("measurement.test.int_flag", -2, -2, zzby.zza);
    public static zzeu<Double> zzak;
    public static zzeu<Integer> zzal = zza("measurement.experiment.max_ids", 50, 50, zzca.zza);
    public static zzeu<Boolean> zzam = zza("measurement.validation.internal_limits_internal_event_params", false, false, zzbz.zza);
    public static zzeu<Boolean> zzan = zza("measurement.referrer.enable_logging_install_referrer_cmp_from_apk", false, false, zzcc.zza);
    public static zzeu<Boolean> zzao = zza("measurement.client.sessions.session_id_enabled", true, true, zzce.zza);
    public static zzeu<Boolean> zzap = zza("measurement.service.sessions.session_number_enabled", true, true, zzcd.zza);
    public static zzeu<Boolean> zzaq = zza("measurement.client.sessions.background_sessions_enabled", true, true, zzcg.zza);
    public static zzeu<Boolean> zzar = zza("measurement.client.sessions.remove_expired_session_properties_enabled", true, true, zzcf.zza);
    public static zzeu<Boolean> zzas = zza("measurement.service.sessions.session_number_backfill_enabled", true, true, zzci.zza);
    public static zzeu<Boolean> zzat = zza("measurement.service.sessions.remove_disabled_session_number", true, true, zzch.zza);
    public static zzeu<Boolean> zzau = zza("measurement.client.sessions.start_session_before_view_screen", true, true, zzck.zza);
    public static zzeu<Boolean> zzav = zza("measurement.client.sessions.check_on_startup", true, true, zzcj.zza);
    public static zzeu<Boolean> zzaw = zza("measurement.collection.firebase_global_collection_flag_enabled", true, true, zzcm.zza);
    public static zzeu<Boolean> zzax = zza("measurement.collection.efficient_engagement_reporting_enabled", false, false, zzcl.zza);
    public static zzeu<Boolean> zzay = zza("measurement.collection.redundant_engagement_removal_enabled", false, false, zzcn.zza);
    public static zzeu<Boolean> zzaz = zza("measurement.personalized_ads_signals_collection_enabled", true, true, zzcq.zza);
    public static zzeu<Long> zzb = zza("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, zzar.zza);
    public static zzeu<Boolean> zzba = zza("measurement.personalized_ads_property_translation_enabled", true, true, zzcp.zza);
    public static zzeu<Boolean> zzbb = zza("measurement.upload.disable_is_uploader", true, true, zzcs.zza);
    public static zzeu<Boolean> zzbc = zza("measurement.experiment.enable_experiment_reporting", true, true, zzcr.zza);
    public static zzeu<Boolean> zzbd = zza("measurement.collection.log_event_and_bundle_v2", true, true, zzcu.zza);
    public static zzeu<Boolean> zzbe = zza("measurement.quality.checksum", false, false, null);
    public static zzeu<Boolean> zzbf = zza("measurement.module.collection.conditionally_omit_admob_app_id", true, true, zzct.zza);
    public static zzeu<Boolean> zzbg = zza("measurement.sdk.dynamite.use_dynamite2", false, false, zzcw.zza);
    public static zzeu<Boolean> zzbh = zza("measurement.sdk.dynamite.allow_remote_dynamite", false, false, zzcv.zza);
    public static zzeu<Boolean> zzbi = zza("measurement.sdk.collection.validate_param_names_alphabetical", false, false, zzcy.zza);
    public static zzeu<Boolean> zzbj = zza("measurement.collection.event_safelist", true, true, zzda.zza);
    public static zzeu<Boolean> zzbk = zza("measurement.service.audience.scoped_filters_v27", true, true, zzcz.zza);
    public static zzeu<Boolean> zzbl = zza("measurement.service.audience.session_scoped_event_aggregates", true, true, zzdc.zza);
    public static zzeu<Boolean> zzbm = zza("measurement.service.audience.session_scoped_user_engagement", true, true, zzdb.zza);
    public static zzeu<Boolean> zzbn = zza("measurement.service.audience.scoped_engagement_removal_when_session_expired", true, true, zzde.zza);
    public static zzeu<Boolean> zzbo = zza("measurement.client.audience.scoped_engagement_removal_when_session_expired", true, true, zzdd.zza);
    public static zzeu<Boolean> zzbp = zza("measurement.service.audience.remove_disabled_session_scoped_user_engagement", false, false, zzdg.zza);
    public static zzeu<Boolean> zzbq = zza("measurement.service.audience.use_bundle_timestamp_for_property_filters", true, true, zzdf.zza);
    public static zzeu<Boolean> zzbr = zza("measurement.service.audience.fix_prepending_previous_sequence_timestamp", true, true, zzdi.zza);
    public static zzeu<Boolean> zzbs = zza("measurement.service.audience.fix_skip_audience_with_failed_filters", true, true, zzdj.zza);
    public static zzeu<Boolean> zzbt = zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false, false, zzdm.zza);
    public static zzeu<Boolean> zzbu = zza("measurement.audience.refresh_event_count_filters_timestamp", false, false, zzdl.zza);
    public static zzeu<Boolean> zzbv = zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false, false, zzdo.zza);
    public static zzeu<Boolean> zzbw = zza("measurement.sdk.collection.retrieve_deeplink_from_bow_2", true, true, zzdn.zza);
    public static zzeu<Boolean> zzbx = zza("measurement.app_launch.event_ordering_fix", false, false, zzdq.zza);
    public static zzeu<Boolean> zzby = zza("measurement.sdk.collection.last_deep_link_referrer2", false, false, zzdp.zza);
    public static zzeu<Boolean> zzbz = zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false, false, zzds.zza);
    public static zzeu<Long> zzc = zza("measurement.config.cache_time", 86400000L, 3600000L, zzbf.zza);
    public static zzeu<Boolean> zzca = zza("measurement.sdk.collection.last_gclid_from_referrer2", false, false, zzdr.zza);
    public static zzeu<Boolean> zzcb = zza("measurement.sdk.collection.worker_thread_referrer", true, true, zzdu.zza);
    public static zzeu<Boolean> zzcc = zza("measurement.sdk.collection.enable_extend_user_property_size", true, true, zzdw.zza);
    public static zzeu<Boolean> zzcd = zza("measurement.upload.file_lock_state_check", false, false, zzdv.zza);
    public static zzeu<Boolean> zzce = zza("measurement.sampling.calculate_bundle_timestamp_before_sampling", true, true, zzdy.zza);
    public static zzeu<Boolean> zzcf = zza("measurement.ga.ga_app_id", false, false, zzdx.zza);
    public static zzeu<Boolean> zzcg = zza("measurement.lifecycle.app_backgrounded_tracking", true, true, zzea.zza);
    public static zzeu<Boolean> zzch = zza("measurement.lifecycle.app_in_background_parameter", false, false, zzdz.zza);
    public static zzeu<Boolean> zzci = zza("measurement.integration.disable_firebase_instance_id", false, false, zzec.zza);
    public static zzeu<Boolean> zzcj = zza("measurement.lifecycle.app_backgrounded_engagement", false, false, zzeb.zza);
    public static zzeu<Boolean> zzck = zza("measurement.service.fix_gmp_version", false, false, zzee.zza);
    public static zzeu<Boolean> zzcl = zza("measurement.collection.service.update_with_analytics_fix", false, false, zzed.zza);
    public static zzeu<Boolean> zzcm = zza("measurement.service.disable_install_state_reporting", false, false, zzef.zza);
    public static zzeu<Boolean> zzcn = zza("measurement.service.use_appinfo_modified", false, false, zzei.zza);
    public static zzeu<Boolean> zzco = zza("measurement.client.firebase_feature_rollout.v1.enable", true, true, zzeh.zza);
    public static zzeu<Boolean> zzcp = zza("measurement.client.sessions.check_on_reset_and_enable", false, false, zzek.zza);
    public static zzeu<Boolean> zzcq = zza("measurement.config.string.always_update_disk_on_set", false, false, zzej.zza);
    public static zzeu<Boolean> zzcr = zza("measurement.scheduler.task_thread.cleanup_on_exit", false, false, zzem.zza);
    public static zzeu<Boolean> zzcs = zza("measurement.upload.file_truncate_fix", false, false, zzel.zza);
    public static zzeu<Boolean> zzct = zza("measurement.lifecycle.app_background_timestamp_when_backgrounded", true, true, zzeo.zza);
    public static zzeu<Boolean> zzcu = zza("measurement.engagement_time_main_thread", false, false, zzen.zza);
    public static zzeu<Boolean> zzcv = zza("measurement.sdk.referrer.delayed_install_referrer_api", false, false, zzeq.zza);
    public static zzeu<Boolean> zzcw = zza("measurement.logging.improved_messaging_q4_2019_client", true, true, zzat.zza);
    public static zzeu<Boolean> zzcx = zza("measurement.logging.improved_messaging_q4_2019_service", true, true, zzaw.zza);
    public static zzeu<Boolean> zzcy = zza("measurement.gold.enhanced_ecommerce.format_logs", false, false, zzav.zza);
    private static List<zzeu<?>> zzcz = Collections.synchronizedList(new ArrayList());
    public static zzeu<String> zzd = zza("measurement.config.url_scheme", "https", "https", zzbs.zza);
    private static Set<zzeu<?>> zzda = Collections.synchronizedSet(new HashSet());
    private static zzeu<Boolean> zzdb = zza("measurement.service.audience.invalidate_config_cache_after_app_unisntall", true, true, zzdh.zza);
    public static zzeu<String> zze = zza("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", zzcb.zza);
    public static zzeu<Integer> zzf = zza("measurement.upload.max_bundles", 100, 100, zzco.zza);
    public static zzeu<Integer> zzg = zza("measurement.upload.max_batch_size", 65536, 65536, zzcx.zza);
    public static zzeu<Integer> zzh = zza("measurement.upload.max_bundle_size", 65536, 65536, zzdk.zza);
    public static zzeu<Integer> zzi = zza("measurement.upload.max_events_per_bundle", 1000, 1000, zzdt.zza);
    public static zzeu<Integer> zzj = zza("measurement.upload.max_events_per_day", 100000, 100000, zzeg.zza);
    public static zzeu<Integer> zzk = zza("measurement.upload.max_error_events_per_day", 1000, 1000, zzau.zza);
    public static zzeu<Integer> zzl = zza("measurement.upload.max_public_events_per_day", 50000, 50000, zzay.zza);
    public static zzeu<Integer> zzm = zza("measurement.upload.max_conversions_per_day", 500, 500, zzax.zza);
    public static zzeu<Integer> zzn = zza("measurement.upload.max_realtime_events_per_day", 10, 10, zzba.zza);
    public static zzeu<Integer> zzo = zza("measurement.store.max_stored_events_per_app", 100000, 100000, zzaz.zza);
    public static zzeu<String> zzp = zza("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", zzbc.zza);
    public static zzeu<Long> zzq = zza("measurement.upload.backoff_period", 43200000L, 43200000L, zzbb.zza);
    public static zzeu<Long> zzr = zza("measurement.upload.window_interval", 3600000L, 3600000L, zzbe.zza);
    public static zzeu<Long> zzs = zza("measurement.upload.interval", 3600000L, 3600000L, zzbd.zza);
    public static zzeu<Long> zzt = zza("measurement.upload.realtime_upload_interval", 10000L, 10000L, zzbg.zza);
    public static zzeu<Long> zzu = zza("measurement.upload.debug_upload_interval", 1000L, 1000L, zzbi.zza);
    public static zzeu<Long> zzv = zza("measurement.upload.minimum_delay", 500L, 500L, zzbh.zza);
    public static zzeu<Long> zzw = zza("measurement.alarm_manager.minimum_interval", 60000L, 60000L, zzbk.zza);
    public static zzeu<Long> zzx = zza("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, zzbj.zza);
    public static zzeu<Long> zzy = zza("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, zzbm.zza);
    public static zzeu<Long> zzz = zza("measurement.upload.initial_upload_delay_time", 15000L, 15000L, zzbl.zza);

    public static Map<String, String> zza(Context context) {
        zzbz zza2 = zzbz.zza(context.getContentResolver(), zzck.zza("com.google.android.gms.measurement"));
        return zza2 == null ? Collections.emptyMap() : zza2.zza();
    }

    private static <V> zzeu<V> zza(String str, V v, V v2, zzes<V> zzes) {
        zzeu<V> zzeu = new zzeu<>(str, v, v2, zzes);
        zzcz.add(zzeu);
        return zzeu;
    }

    static final /* synthetic */ Long zzcw() {
        if (zzer.zza != null) {
            zzw zzw2 = zzer.zza;
        }
        return Long.valueOf(zzjf.zzc());
    }

    static {
        Integer valueOf = Integer.valueOf((int) ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
        zzae = zza("measurement.audience.filter_result_max_count", valueOf, valueOf, zzbr.zza);
        Double valueOf2 = Double.valueOf(-3.0d);
        zzak = zza("measurement.test.double_flag", valueOf2, valueOf2, zzbx.zza);
    }
}
