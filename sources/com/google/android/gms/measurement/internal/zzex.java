package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.2 */
public final class zzex extends zze {
    private final zzfa zza = new zzfa(this, zzn(), "google_app_measurement_local.db");
    private boolean zzb;

    zzex(zzgf zzgf) {
        super(zzgf);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zze
    public final boolean zzz() {
        return false;
    }

    public final void zzab() {
        zzb();
        zzd();
        try {
            int delete = zzae().delete("messages", null, null) + 0;
            if (delete > 0) {
                zzr().zzx().zza("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error resetting local analytics data. error", e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cb A[SYNTHETIC, Splitter:B:46:0x00cb] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0122 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0122 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0122 A[SYNTHETIC] */
    private final boolean zza(int i, byte[] bArr) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        SQLiteFullException e;
        Cursor cursor;
        SQLiteException e2;
        zzb();
        zzd();
        boolean z = false;
        if (this.zzb) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i));
        contentValues.put("entry", bArr);
        int i2 = 0;
        int i3 = 5;
        for (int i4 = 5; i2 < i4; i4 = 5) {
            Cursor cursor2 = null;
            r7 = null;
            cursor2 = null;
            r7 = null;
            SQLiteDatabase sQLiteDatabase2 = null;
            Cursor cursor3 = null;
            try {
                sQLiteDatabase = zzae();
                if (sQLiteDatabase == null) {
                    try {
                        this.zzb = true;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        return z;
                    } catch (SQLiteFullException e3) {
                        e = e3;
                    } catch (SQLiteDatabaseLockedException e4) {
                        try {
                            SystemClock.sleep((long) i3);
                            i3 += 20;
                            if (cursor3 != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            i2++;
                            z = false;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor3 != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            throw th;
                        }
                    } catch (SQLiteException e5) {
                        e2 = e5;
                        cursor = null;
                        sQLiteDatabase2 = sQLiteDatabase;
                        if (sQLiteDatabase2 != null) {
                        }
                        zzr().zzf().zza("Error writing entry to local database", e2);
                        this.zzb = true;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase2 != null) {
                        }
                        i2++;
                        z = false;
                    }
                } else {
                    sQLiteDatabase.beginTransaction();
                    long j = 0;
                    cursor = sQLiteDatabase.rawQuery("select count(1) from messages", null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                int i5 = z ? 1 : 0;
                                int i6 = z ? 1 : 0;
                                int i7 = z ? 1 : 0;
                                j = cursor.getLong(i5);
                            }
                        } catch (SQLiteFullException e6) {
                            e = e6;
                            cursor2 = cursor;
                            zzr().zzf().zza("Error writing entry; local database full", e);
                            this.zzb = true;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            if (sQLiteDatabase == null) {
                                sQLiteDatabase.close();
                            }
                            i2++;
                            z = false;
                        } catch (SQLiteDatabaseLockedException e7) {
                            cursor3 = cursor;
                            SystemClock.sleep((long) i3);
                            i3 += 20;
                            if (cursor3 != null) {
                                cursor3.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            i2++;
                            z = false;
                        } catch (SQLiteException e8) {
                            e2 = e8;
                            sQLiteDatabase2 = sQLiteDatabase;
                            if (sQLiteDatabase2 != null) {
                                try {
                                    if (sQLiteDatabase2.inTransaction()) {
                                        sQLiteDatabase2.endTransaction();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    sQLiteDatabase = sQLiteDatabase2;
                                    cursor3 = cursor;
                                    if (cursor3 != null) {
                                    }
                                    if (sQLiteDatabase != null) {
                                    }
                                    throw th;
                                }
                            }
                            zzr().zzf().zza("Error writing entry to local database", e2);
                            this.zzb = true;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase2 != null) {
                                sQLiteDatabase2.close();
                            }
                            i2++;
                            z = false;
                        } catch (Throwable th4) {
                            th = th4;
                            cursor3 = cursor;
                            if (cursor3 != null) {
                                cursor3.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            throw th;
                        }
                    }
                    if (j >= 100000) {
                        zzr().zzf().zza("Data loss, local db full");
                        long j2 = (100000 - j) + 1;
                        String[] strArr = new String[1];
                        String l = Long.toString(j2);
                        char c = z ? 1 : 0;
                        char c2 = z ? 1 : 0;
                        char c3 = z ? 1 : 0;
                        strArr[c] = l;
                        long delete = (long) sQLiteDatabase.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", strArr);
                        if (delete != j2) {
                            zzr().zzf().zza("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(delete), Long.valueOf(j2 - delete));
                        }
                    }
                    sQLiteDatabase.insertOrThrow("messages", null, contentValues);
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase == null) {
                        return true;
                    }
                    sQLiteDatabase.close();
                    return true;
                }
            } catch (SQLiteFullException e9) {
                e = e9;
                sQLiteDatabase = null;
                zzr().zzf().zza("Error writing entry; local database full", e);
                this.zzb = true;
                if (cursor2 != null) {
                }
                if (sQLiteDatabase == null) {
                }
                i2++;
                z = false;
            } catch (SQLiteDatabaseLockedException e10) {
                sQLiteDatabase = null;
                SystemClock.sleep((long) i3);
                i3 += 20;
                if (cursor3 != null) {
                }
                if (sQLiteDatabase != null) {
                }
                i2++;
                z = false;
            } catch (SQLiteException e11) {
                e2 = e11;
                cursor = null;
                if (sQLiteDatabase2 != null) {
                }
                zzr().zzf().zza("Error writing entry to local database", e2);
                this.zzb = true;
                if (cursor != null) {
                }
                if (sQLiteDatabase2 != null) {
                }
                i2++;
                z = false;
            } catch (Throwable th5) {
                th = th5;
                sQLiteDatabase = null;
                if (cursor3 != null) {
                }
                if (sQLiteDatabase != null) {
                }
                throw th;
            }
        }
        zzr().zzx().zza("Failed to write entry to local database");
        return false;
    }

    public final boolean zza(zzan zzan) {
        Parcel obtain = Parcel.obtain();
        zzan.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(0, marshall);
        }
        zzr().zzg().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzkq zzkq) {
        Parcel obtain = Parcel.obtain();
        zzkq.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(1, marshall);
        }
        zzr().zzg().zza("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zza(zzv zzv) {
        zzp();
        byte[] zza2 = zzkv.zza((Parcelable) zzv);
        if (zza2.length <= 131072) {
            return zza(2, zza2);
        }
        zzr().zzg().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01ff, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0204, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0209, code lost:
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x020d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x021e, code lost:
        if (r15.inTransaction() != false) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0220, code lost:
        r15.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0232, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0237, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0246, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x024b, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x026f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0273, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0278, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0070, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0073, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0208 A[ExcHandler: SQLiteDatabaseLockedException (e android.database.sqlite.SQLiteDatabaseLockedException), Splitter:B:12:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x021a A[SYNTHETIC, Splitter:B:133:0x021a] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0269 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0269 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0269 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final List<AbstractSafeParcelable> zza(int i) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        Throwable th;
        Cursor cursor2;
        SQLiteFullException e;
        SQLiteDatabase sQLiteDatabase2;
        SQLiteException e2;
        SQLiteDatabase sQLiteDatabase3;
        int i2;
        zzv zzv;
        zzkq zzkq;
        String[] strArr;
        String str;
        zzd();
        zzb();
        ?? r3 = 0;
        if (this.zzb) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!zzaf()) {
            return arrayList;
        }
        int i3 = 0;
        int i4 = 5;
        for (int i5 = 5; i3 < i5; i5 = 5) {
            try {
                sQLiteDatabase = zzae();
                if (sQLiteDatabase == null) {
                    try {
                        this.zzb = true;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        return r3;
                    } catch (SQLiteFullException e3) {
                        e = e3;
                        cursor2 = r3;
                    } catch (SQLiteDatabaseLockedException e4) {
                    } catch (SQLiteException e5) {
                        e2 = e5;
                        cursor2 = r3;
                        if (sQLiteDatabase != null) {
                        }
                        zzr().zzf().zza("Error reading entries from local database", e2);
                        this.zzb = true;
                        if (cursor2 != null) {
                        }
                        if (sQLiteDatabase == null) {
                        }
                        i3++;
                        r3 = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = r3;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase != null) {
                        }
                        throw th;
                    }
                } else {
                    sQLiteDatabase.beginTransaction();
                    long j = -1;
                    if (zzt().zza(zzap.zzbx)) {
                        long zza2 = zza(sQLiteDatabase);
                        if (zza2 != -1) {
                            str = "rowid<?";
                            strArr = new String[]{String.valueOf(zza2)};
                        } else {
                            str = null;
                            strArr = null;
                        }
                        i2 = 3;
                        sQLiteDatabase3 = sQLiteDatabase;
                        try {
                            cursor2 = sQLiteDatabase.query("messages", new String[]{"rowid", "type", "entry"}, str, strArr, null, null, "rowid asc", Integer.toString(100));
                        } catch (SQLiteFullException e6) {
                            e = e6;
                            sQLiteDatabase = sQLiteDatabase3;
                            cursor2 = null;
                            zzr().zzf().zza("Error reading entries from local database", e);
                            this.zzb = true;
                            if (cursor2 != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            i3++;
                            r3 = 0;
                        } catch (SQLiteDatabaseLockedException e7) {
                            sQLiteDatabase2 = sQLiteDatabase3;
                            cursor2 = null;
                            SystemClock.sleep((long) i4);
                            i4 += 20;
                            if (cursor2 != null) {
                            }
                            if (sQLiteDatabase2 == null) {
                            }
                            i3++;
                            r3 = 0;
                        } catch (SQLiteException e8) {
                            e2 = e8;
                            sQLiteDatabase = sQLiteDatabase3;
                            cursor2 = null;
                            if (sQLiteDatabase != null) {
                            }
                            zzr().zzf().zza("Error reading entries from local database", e2);
                            this.zzb = true;
                            if (cursor2 != null) {
                            }
                            if (sQLiteDatabase == null) {
                            }
                            i3++;
                            r3 = 0;
                        } catch (Throwable th3) {
                            th = th3;
                            sQLiteDatabase = sQLiteDatabase3;
                            cursor = null;
                            if (cursor != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            throw th;
                        }
                    } else {
                        sQLiteDatabase3 = sQLiteDatabase;
                        i2 = 3;
                        cursor2 = sQLiteDatabase3.query("messages", new String[]{"rowid", "type", "entry"}, null, null, null, null, "rowid asc", Integer.toString(100));
                    }
                    while (cursor2.moveToNext()) {
                        try {
                            j = cursor2.getLong(0);
                            int i6 = cursor2.getInt(1);
                            byte[] blob = cursor2.getBlob(2);
                            if (i6 == 0) {
                                Parcel obtain = Parcel.obtain();
                                try {
                                    obtain.unmarshall(blob, 0, blob.length);
                                    obtain.setDataPosition(0);
                                    zzan createFromParcel = zzan.CREATOR.createFromParcel(obtain);
                                    obtain.recycle();
                                    if (createFromParcel != null) {
                                        arrayList.add(createFromParcel);
                                    }
                                } catch (SafeParcelReader.ParseException e9) {
                                    zzr().zzf().zza("Failed to load event from local database");
                                    obtain.recycle();
                                } catch (Throwable th4) {
                                    obtain.recycle();
                                    throw th4;
                                }
                            } else if (i6 == 1) {
                                Parcel obtain2 = Parcel.obtain();
                                try {
                                    obtain2.unmarshall(blob, 0, blob.length);
                                    obtain2.setDataPosition(0);
                                    zzkq = zzkq.CREATOR.createFromParcel(obtain2);
                                    obtain2.recycle();
                                } catch (SafeParcelReader.ParseException e10) {
                                    zzr().zzf().zza("Failed to load user property from local database");
                                    obtain2.recycle();
                                    zzkq = null;
                                } catch (Throwable th5) {
                                    obtain2.recycle();
                                    throw th5;
                                }
                                if (zzkq != null) {
                                    arrayList.add(zzkq);
                                }
                            } else if (i6 == 2) {
                                Parcel obtain3 = Parcel.obtain();
                                try {
                                    obtain3.unmarshall(blob, 0, blob.length);
                                    obtain3.setDataPosition(0);
                                    zzv = zzv.CREATOR.createFromParcel(obtain3);
                                    obtain3.recycle();
                                } catch (SafeParcelReader.ParseException e11) {
                                    zzr().zzf().zza("Failed to load conditional user property from local database");
                                    obtain3.recycle();
                                    zzv = null;
                                } catch (Throwable th6) {
                                    obtain3.recycle();
                                    throw th6;
                                }
                                if (zzv != null) {
                                    arrayList.add(zzv);
                                }
                            } else if (i6 == i2) {
                                zzr().zzi().zza("Skipping app launch break");
                            } else {
                                zzr().zzf().zza("Unknown record type in local database");
                            }
                        } catch (SQLiteFullException e12) {
                            e = e12;
                            sQLiteDatabase = sQLiteDatabase3;
                            zzr().zzf().zza("Error reading entries from local database", e);
                            this.zzb = true;
                            if (cursor2 != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            i3++;
                            r3 = 0;
                        } catch (SQLiteDatabaseLockedException e13) {
                            sQLiteDatabase2 = sQLiteDatabase3;
                            SystemClock.sleep((long) i4);
                            i4 += 20;
                            if (cursor2 != null) {
                            }
                            if (sQLiteDatabase2 == null) {
                            }
                            i3++;
                            r3 = 0;
                        } catch (SQLiteException e14) {
                            e2 = e14;
                            sQLiteDatabase = sQLiteDatabase3;
                            if (sQLiteDatabase != null) {
                            }
                            zzr().zzf().zza("Error reading entries from local database", e2);
                            this.zzb = true;
                            if (cursor2 != null) {
                            }
                            if (sQLiteDatabase == null) {
                            }
                            i3++;
                            r3 = 0;
                        } catch (Throwable th7) {
                            th = th7;
                            sQLiteDatabase = sQLiteDatabase3;
                            cursor = cursor2;
                            if (cursor != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            throw th;
                        }
                    }
                    if (sQLiteDatabase3.delete("messages", "rowid <= ?", new String[]{Long.toString(j)}) < arrayList.size()) {
                        zzr().zzf().zza("Fewer entries removed from local database than expected");
                    }
                    sQLiteDatabase3.setTransactionSuccessful();
                    sQLiteDatabase3.endTransaction();
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.close();
                    }
                    return arrayList;
                }
            } catch (SQLiteFullException e15) {
                e = e15;
                cursor2 = null;
                sQLiteDatabase = null;
                zzr().zzf().zza("Error reading entries from local database", e);
                this.zzb = true;
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                i3++;
                r3 = 0;
            } catch (SQLiteDatabaseLockedException e16) {
                cursor2 = null;
                sQLiteDatabase2 = null;
                SystemClock.sleep((long) i4);
                i4 += 20;
                if (cursor2 != null) {
                }
                if (sQLiteDatabase2 == null) {
                }
                i3++;
                r3 = 0;
            } catch (SQLiteException e17) {
                e2 = e17;
                cursor2 = null;
                sQLiteDatabase = null;
                if (sQLiteDatabase != null) {
                }
                zzr().zzf().zza("Error reading entries from local database", e2);
                this.zzb = true;
                if (cursor2 != null) {
                }
                if (sQLiteDatabase == null) {
                }
                i3++;
                r3 = 0;
            } catch (Throwable th8) {
                th = th8;
                cursor = null;
                sQLiteDatabase = null;
                if (cursor != null) {
                }
                if (sQLiteDatabase != null) {
                }
                throw th;
            }
        }
        zzr().zzi().zza("Failed to read events from database in reasonable time");
        return null;
    }

    public final boolean zzac() {
        return zza(3, new byte[0]);
    }

    public final boolean zzad() {
        zzd();
        zzb();
        if (this.zzb || !zzaf()) {
            return false;
        }
        int i = 5;
        for (int i2 = 0; i2 < 5; i2++) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase zzae = zzae();
                if (zzae == null) {
                    this.zzb = true;
                    if (zzae != null) {
                        zzae.close();
                    }
                    return false;
                }
                zzae.beginTransaction();
                zzae.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                zzae.setTransactionSuccessful();
                zzae.endTransaction();
                if (zzae != null) {
                    zzae.close();
                }
                return true;
            } catch (SQLiteFullException e) {
                zzr().zzf().zza("Error deleting app launch break from local database", e);
                this.zzb = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteDatabaseLockedException e2) {
                SystemClock.sleep((long) i);
                i += 20;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteException e3) {
                if (0 != 0) {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                }
                zzr().zzf().zza("Error deleting app launch break from local database", e3);
                this.zzb = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
        zzr().zzi().zza("Error deleting app launch break from local database in reasonable time");
        return false;
    }

    private static long zza(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, null, null, "rowid desc", "1");
            if (cursor.moveToFirst()) {
                return cursor.getLong(0);
            }
            if (cursor == null) {
                return -1;
            }
            cursor.close();
            return -1;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private final SQLiteDatabase zzae() throws SQLiteException {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    private final boolean zzaf() {
        return zzn().getDatabasePath("google_app_measurement_local.db").exists();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzb zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzhk zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzey zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzis zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzin zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzex zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzjt zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzah zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzhc, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzhc, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzez zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzkv zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzhc, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzgc zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzhc, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzfb zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzfo zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzhc, com.google.android.gms.measurement.internal.zzha
    public final /* bridge */ /* synthetic */ zzw zzu() {
        return super.zzu();
    }
}
